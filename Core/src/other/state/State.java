package other.state;

import java.io.Serializable;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import annotations.Hide;
import game.Game;
import game.Game.StateConstructorLock;
import game.equipment.container.Container;
import game.equipment.container.other.Dice;
import game.functions.ints.last.LastFrom;
import game.functions.ints.last.LastTo;
import game.rules.phase.Phase;
import game.types.board.SiteType;
import game.types.play.ModeType;
import game.types.play.RoleType;
import game.types.state.GameType;
import game.util.equipment.Region;
import gnu.trove.iterator.TIntIterator;
import gnu.trove.list.array.TIntArrayList;
import gnu.trove.map.TIntObjectMap;
import gnu.trove.map.TObjectIntMap;
import gnu.trove.map.hash.TIntObjectHashMap;
import gnu.trove.map.hash.TObjectIntHashMap;
import gnu.trove.set.hash.TIntHashSet;
import main.Constants;
import main.collections.FastTIntArrayList;
import other.context.Context;
import other.state.container.ContainerState;
import other.state.container.ContainerStateFactory;
import other.state.owned.Owned;
import other.state.owned.OwnedFactory;
import other.state.symmetry.SymmetryValidator;
import other.state.track.OnTrackIndices;
import other.state.zhash.ZobristHashGenerator;
import other.state.zhash.ZobristHashUtilities;

/**
 * Game state.
 *
 * @author Eric.Piette and cambolbro
 */
@Hide
public abstract class State implements Serializable {

    private static final long serialVersionUID = 1L;

    //-------------------------------------------------------------------------
    private static final int TURN_MAX_HASH = 1024;

    private static final int SCORE_MAX_HASH = 1024;

    protected static final int AMOUNT_MAX_HASH = 1024;

    //-------------------------------------------------------------------------
    /**
     * Current player to move.
     */
    protected int mover = 0;

    /**
     * Next player to move (if no special rules override this).
     */
    protected int next = 0;

    /**
     * Previous player to move.
     */
    protected int prev = 0;

    /**
     * For every player, a bit indicating whether some condition is triggered (e.g. checkmate).
     */
    protected int triggered = 0;

    /**
     * For every player, a bit indicating whether they are stalemated.
     */
    protected int stalemated = 0;

    /**
     * Individual container states.
     */
    protected ContainerState[] containerStates;

    /**
     * Variable for using a counter associated to the state (possibly reSet at 0 by a consequence of an action)
     */
    protected int counter = Constants.UNDEFINED;

    /**
     * Variable to store a value between two states.
     */
    protected int tempValue = Constants.UNDEFINED;

    /**
     * The money pot.
     */
    protected int moneyPot = 0;

    /**
     * Current Phase for each player.
     */
    protected int[] currentPhase;

    /**
     * The number of turns played successively by the same player.
     */
    protected int numTurnSamePlayer = 0;

    /**
     * The number of times the mover has been switched to a different player.
     */
    protected int numTurn = 1;

    /**
     * The trump suit of the game (for cards games).
     */
    protected int trumpSuit = Constants.OFF;

    /**
     * The decision after voting.
     */
    protected int isDecided = Constants.UNDEFINED;

    /**
     * Access to list of sites for each kind of component owned per player. First
     * indexed by player index, then by component index.
     *
     * Will contain null entries for cases where a component cannot be owned by a
     * certain player.
     */
    protected transient Owned owned;

    /**
     * Indexed by original player/agent index at game start.
     * Gives us the matching player index at current game state (may be different after swaps)
     */
    protected int[] playerOrder;

    /**
     * The state stored temporary by the game.
     */
    protected long storedState = 0L;

    /**
     * Number of consecutive pass moves
     */
    protected int numConsecutivePasses = 0;

    /**
     * Assumed cap on number of consecutive pass moves (for hash code purposes)
     */
    protected int numConsecutivePassesHashCap;

    /*
	 * -------------------------------------------------------------------------
	 * Zobrist hashing - attempts to reduce the board state to a 64 bit number
	 * 
	 * These values are incrementally updated every time the state changes 
	 * For repetition and ko, you'll want the current board state, but this is not the whole story 
	 * The generated move tree from a given node is affected by other factors; player to move, 
	 * your countdown variables, etc.  These should be included when searching with transposition 
	 * tables if you want an accurate description of the node score
	 * -------------------------------------------------------------------------
	 */
    // Includes container states and scores
    private long stateHash;

    private long moverHash;

    private long nextHash;

    private long prevHash;

    private long activeHash;

    private long checkmatedHash;

    private long stalematedHash;

    private long pendingHash;

    // Hash value for scores
    private long scoreHash;

    // Hash value for amounts
    protected long amountHash;

    protected long[] moverHashes;

    protected long[] nextHashes;

    protected long[] prevHashes;

    protected long[] activeHashes;

    protected long[] checkmatedHashes;

    protected long[] stalematedHashes;

    protected long[][] lowScoreHashes;

    protected long[][] highScoreHashes;

    protected long[][] lowAmountHashes;

    protected long[][] highAmountHashes;

    protected long[][] phaseHashes;

    protected long[] isPendingHashes;

    protected long[] tempHashes;

    protected long[][] playerOrderHashes;

    protected long[][] consecutiveTurnHashes;

    protected long[][] playerSwitchHashes;

    protected long[][] teamHashes;

    protected long[][] numConsecutivePassesHashes;

    protected long[] lastFromHashes;

    protected long[] lastToHashes;

    /**
     * @param delta incremental hash to be xored with value
     */
    public void updateStateHash(final long delta) {
        //		final long old = stateHash;
        stateHash ^= delta;
        //		if (old != stateHash)
        //		{
        //			final String stacktraceString = Utilities.stackTraceString();
        //			if
        //			(
        //				!stacktraceString.contains("getMoveStringToDisplay")
        //				&&
        //				!stacktraceString.contains("other.context.InformationContext.moves")
        //				&&
        //				!stacktraceString.contains("game.rules.play.moves.Moves$1.canMoveConditionally(Moves.java:305)")
        //			)
        //			{
        //				System.out.println("Updated stateHash from " + old + " to " + stateHash);
        //				Utilities.stackTrace();
        //			}
        //		}
    }

    /**
     * Performance warning: this is slow, do not use during search!
     * Returns the lowest hash from the containers after all symmetries have been applied
     * @param validator allows selection of a subset of available symmetries
     * @param whoOnly only hash the 'who' values - this is required for games with undifferentiated pieces
     * @return state hash value
     */
    public long canonicalHash(final SymmetryValidator validator, final boolean whoOnly) {
        final ContainerState boardState = containerStates[0];
        final long canonicalBoardHash = boardState.canonicalHash(validator, this, whoOnly);
        return canonicalBoardHash == 0 ? stateHash : canonicalBoardHash;
    }

    //	/**
    //	 * @deprecated use canonicalhash(validator,whoOnly) instead
    //	 * @param validator
    //	 * @return state hash value for the whole state
    //	 */
    //	@Deprecated
    //	public long canonicalHash(final SymmetryValidator validator)
    //	{
    //		return canonicalHash(validator, false);
    //	}
    /**
     * @return state hash value
     */
    public long stateHash() {
        return stateHash;
    }

    /**
     * @return pending hash value
     */
    protected long pendingHash() {
        return pendingHash;
    }

    /**
     * @return hash value for number of times turn has remained the same
     */
    protected long consecutiveTurnHash() {
        return numTurnSamePlayer < Constants.MAX_CONSECUTIVES_TURNS ? consecutiveTurnHashes[0][numTurnSamePlayer] : consecutiveTurnHashes[1][numTurnSamePlayer % Constants.MAX_CONSECUTIVES_TURNS];
    }

    /**
     * @return hash value for number of times turn has changed
     */
    // TODO why is this not in full hash?
    protected long playerNumSwitchesHash() {
        return numTurn < TURN_MAX_HASH ? playerSwitchHashes[0][numTurn] : playerSwitchHashes[1][numTurn % TURN_MAX_HASH];
    }

    /**
     * @return Hash value for number of consecutive passes
     */
    protected long numConsecutivePassesHash() {
        return numConsecutivePasses < numConsecutivePassesHashCap ? numConsecutivePassesHashes[0][numConsecutivePasses] : numConsecutivePassesHashes[1][numConsecutivePasses % numConsecutivePassesHashCap];
    }

    /**
     * @return full hash value containing all fields
     */
    public long fullHash() {
        return moverHash ^ nextHash ^ prevHash ^ activeHash ^ checkmatedHash ^ stalematedHash ^ pendingHash() ^ stateHash() ^ consecutiveTurnHash() ^ scoreHash ^ amountHash ^ numConsecutivePassesHash();
    }

    private static final LastFrom LAST_FROM_LUDEME = new LastFrom(null);

    private static final LastTo LAST_TO_LUDEME = new LastTo(null);

    /**
     * @param context
     * @return Full hash value
     */
    public long fullHash(final Context context) {
        final int lastFrom = LAST_FROM_LUDEME.eval(context) + 1;
        final int lastTo = LAST_TO_LUDEME.eval(context) + 1;
        long hash = fullHash();
        if (lastFrom < lastFromHashes.length)
            hash ^= lastFromHashes[lastFrom];
        else
            hash ^= lastFromHashes[lastFrom % lastFromHashes.length];
        if (lastTo < lastToHashes.length)
            hash ^= lastToHashes[lastTo];
        else
            hash ^= lastToHashes[lastTo % lastToHashes.length];
        return hash;
    }

    //-------------------------------------------------------------------------
    /**
     * Default constructor.
     *
     * This constructor is really expensive and should only ever be called
     * (ideally once) by the Game. Any other callers should instead copy
     * the Game's reference state!
     *
     * @param game
     * @param stateConstructorLock Dummy object
     */
    public State(final Game game, final StateConstructorLock stateConstructorLock) {
        Objects.requireNonNull(stateConstructorLock, "Only Game.java should call this constructor! Other callers can copy the game's stateReference instead using the copy constructor.");
        final int numPlayers = game.players().count();
        //-------------- Hash initialisation ----------------
        final ZobristHashGenerator generator = ZobristHashUtilities.getHashGenerator();
        lowScoreHashes = ((game.gameFlags() & GameType.HashScores) != 0L) ? ZobristHashUtilities.getSequence(generator, numPlayers + 1, SCORE_MAX_HASH + 1) : null;
        highScoreHashes = ((game.gameFlags() & GameType.HashScores) != 0L) ? ZobristHashUtilities.getSequence(generator, numPlayers + 1, SCORE_MAX_HASH + 1) : null;
        lowAmountHashes = ((game.gameFlags() & GameType.HashAmounts) != 0L) ? ZobristHashUtilities.getSequence(generator, numPlayers + 1, SCORE_MAX_HASH + 1) : null;
        highAmountHashes = ((game.gameFlags() & GameType.HashAmounts) != 0L) ? ZobristHashUtilities.getSequence(generator, numPlayers + 1, SCORE_MAX_HASH + 1) : null;
        phaseHashes = ((game.gameFlags() & GameType.HashPhases) != 0L) ? ZobristHashUtilities.getSequence(generator, numPlayers + 1, Constants.MAX_PHASES + 1) : null;
        moverHashes = ZobristHashUtilities.getSequence(generator, numPlayers + 1);
        nextHashes = ZobristHashUtilities.getSequence(generator, numPlayers + 1);
        prevHashes = ZobristHashUtilities.getSequence(generator, numPlayers + 1);
        activeHashes = ZobristHashUtilities.getSequence(generator, numPlayers + 1);
        checkmatedHashes = ZobristHashUtilities.getSequence(generator, numPlayers + 1);
        stalematedHashes = ZobristHashUtilities.getSequence(generator, numPlayers + 1);
        // could be negative
        tempHashes = ZobristHashUtilities.getSequence(generator, game.equipment().totalDefaultSites() * Math.max(1, game.maxCount()) + Constants.CONSTANT_RANGE + 1);
        playerOrderHashes = ZobristHashUtilities.getSequence(generator, numPlayers + 1, numPlayers + 1);
        consecutiveTurnHashes = ZobristHashUtilities.getSequence(generator, 2, Constants.MAX_CONSECUTIVES_TURNS);
        playerSwitchHashes = ZobristHashUtilities.getSequence(generator, 2, TURN_MAX_HASH);
        teamHashes = (game.requiresTeams()) ? ZobristHashUtilities.getSequence(generator, numPlayers + 1, Constants.MAX_PLAYER_TEAM + 1) : null;
        numConsecutivePassesHashCap = 2 * numPlayers + 1;
        numConsecutivePassesHashes = ZobristHashUtilities.getSequence(generator, 2, numConsecutivePassesHashCap);
        isPendingHashes = ZobristHashUtilities.getSequence(generator, game.equipment().totalDefaultSites() + 2);
        lastFromHashes = ZobristHashUtilities.getSequence(generator, game.equipment().totalDefaultSites() + 2);
        lastToHashes = ZobristHashUtilities.getSequence(generator, game.equipment().totalDefaultSites() + 2);
        stateHash = ZobristHashUtilities.INITIAL_VALUE;
        scoreHash = ZobristHashUtilities.INITIAL_VALUE;
        amountHash = ZobristHashUtilities.INITIAL_VALUE;
        //-------------- on with the plot ----------------
        playerOrder = new int[numPlayers + 1];
        for (int i = 1; i < playerOrder.length; i++) {
            playerOrder[i] = i;
            updateStateHash(playerOrderHashes[i][playerOrder[i]]);
        }
        assert (!game.hasSubgames());
        moneyPot = 0;
        containerStates = new ContainerState[game.equipment().containers().length];
        int id = 0;
        for (final Container container : game.equipment().containers()) containerStates[id++] = ContainerStateFactory.createStateForContainer(generator, game, container);
        initPhase(game);
        if (game.hasHandDice()) {
            for (int i = 0; i < game.handDice().size(); i++) {
                final Dice d = game.handDice().get(i);
            }
        }
        owned = OwnedFactory.createOwned(game);
    }

    /**
     * Copy constructor.
     *
     * @param other
     */
    public State(final State other) {
        // NOTE: these can be copied by reference, because immutable once initialised
        lowScoreHashes = other.lowScoreHashes;
        highScoreHashes = other.highScoreHashes;
        lowAmountHashes = other.lowAmountHashes;
        highAmountHashes = other.highAmountHashes;
        phaseHashes = other.phaseHashes;
        isPendingHashes = other.isPendingHashes;
        lastFromHashes = other.lastFromHashes;
        lastToHashes = other.lastToHashes;
        moverHashes = other.moverHashes;
        nextHashes = other.nextHashes;
        prevHashes = other.prevHashes;
        activeHashes = other.activeHashes;
        checkmatedHashes = other.checkmatedHashes;
        stalematedHashes = other.stalematedHashes;
        tempHashes = other.tempHashes;
        playerOrderHashes = other.playerOrderHashes;
        consecutiveTurnHashes = other.consecutiveTurnHashes;
        playerSwitchHashes = other.playerSwitchHashes;
        teamHashes = other.teamHashes;
        numConsecutivePassesHashCap = other.numConsecutivePassesHashCap;
        numConsecutivePassesHashes = other.numConsecutivePassesHashes;
        playerOrder = Arrays.copyOf(other.playerOrder, other.playerOrder.length);
        moneyPot = other.moneyPot;
        // Back to the plot
        trumpSuit = other.trumpSuit;
        mover = other.mover;
        next = other.next;
        prev = other.prev;
        triggered = other.triggered;
        stalemated = other.stalemated;
        if (other.containerStates == null) {
            containerStates = null;
        } else {
            containerStates = new ContainerState[other.containerStates.length];
            for (int is = 0; is < containerStates.length; is++) if (other.containerStates[is] == null)
                containerStates[is] = null;
            else
                containerStates[is] = other.containerStates[is].deepClone();
        }
        counter = other.counter;
        tempValue = other.tempValue;
        if (other.currentPhase != null)
            currentPhase = Arrays.copyOf(other.currentPhase, other.currentPhase.length);
        numTurnSamePlayer = other.numTurnSamePlayer;
        numTurn = other.numTurn;
        if (other.owned == null)
            owned = null;
        else
            owned = other.owned.copy();
        storedState = other.storedState;
        numConsecutivePasses = other.numConsecutivePasses;
        stateHash = other.stateHash;
        moverHash = other.moverHash;
        nextHash = other.nextHash;
        prevHash = other.prevHash;
        activeHash = other.activeHash;
        checkmatedHash = other.checkmatedHash;
        stalematedHash = other.stalematedHash;
        pendingHash = other.pendingHash;
        scoreHash = other.scoreHash;
        amountHash = other.amountHash;
        isDecided = other.isDecided;
    }

    //-------------------------------------------------------------------------
    /**
     * @return List of container states
     */
    public ContainerState[] containerStates() {
        return containerStates;
    }

    //-------------------------------------------------------------------------
    /**
     * @return Number of players in the game of which this is a state.
     */
    public int numPlayers() {
        return playerOrder.length - 1;
    }

    /**
     * @return Current mover.
     */
    public int mover() {
        return mover;
    }

    /**
     * @param who
     */
    public void setMover(final int who) {
        moverHash ^= moverHashes[mover];
        mover = who;
        moverHash ^= moverHashes[mover];
    }

    /**
     * @return Next active mover.
     */
    public int next() {
        return next;
    }

    /**
     * To set the next player.
     *
     * @param who
     */
    public void setNext(final int who) {
        nextHash ^= nextHashes[next];
        next = who;
        nextHash ^= nextHashes[next];
    }

    /**
     * @return Previous mover.
     */
    public int prev() {
        return prev;
    }

    /**
     * To set the previous player.
     *
     * @param who
     */
    public void setPrev(final int who) {
        prevHash ^= prevHashes[prev];
        prev = who;
        prevHash ^= prevHashes[prev];
    }

    /**
     * Sets a player to be active or inactive.
     *
     * @param who Which player to set value for
     * @param newActive New active value (true or false for active or inactive)
     * @param active The int with bits set for currently active players
     *
     * @return Returns the modified int with bits set for active players
     */
    public int setActive(final int who, final boolean newActive, final int active) {
        int ret = active;
        final int whoBit = (1 << (who - 1));
        final boolean wasActive = (active & whoBit) != 0;
        if (wasActive && !newActive) {
            activeHash ^= activeHashes[who];
            ret &= ~whoBit;
        } else if (!wasActive && newActive) {
            activeHash ^= activeHashes[who];
            ret |= whoBit;
        }
        return ret;
    }

    /**
     * Updates the zobrist hash if all players have been set to inactive in one go.
     *
     * WARNING: This should only ever be called from Trial
     */
    public void updateHashAllPlayersInactive() {
        activeHash = 0;
    }

    /**
     * @param event The event triggered.
     * @param who   The player related to the event.
     * @return Whether player is triggered.
     */
    public boolean isTriggered(final String event, final int who) {
        return (triggered & (1 << (who - 1))) != 0;
    }

    /**
     * @param who
     * @param triggerValue
     */
    public void triggers(final int who, final boolean triggerValue) {
        final int whoBit = (1 << (who - 1));
        final boolean wasCheckmated = (triggered & whoBit) != 0;
        if (wasCheckmated && !triggerValue) {
            checkmatedHash ^= checkmatedHashes[who];
            triggered &= ~whoBit;
        } else if (!wasCheckmated && triggerValue) {
            checkmatedHash ^= checkmatedHashes[who];
            triggered |= whoBit;
        }
    }

    /**
     * Clear all checkmates.
     */
    public void clearTriggers() {
        checkmatedHash = 0;
        triggered = 0;
    }

    /**
     * @param who
     * @return Whether player is in stalemate.
     */
    public boolean isStalemated(final int who) {
        return (stalemated & (1 << (who - 1))) != 0;
    }

    /**
     * TODO - branching - splitting to setStalemated(who) and clearStalemated(who) would probably be clearer and more efficient
     * To set a player in stalemate (or not).
     *
     * @param who
     * @param newStalemated
     */
    public void setStalemated(final int who, final boolean newStalemated) {
        final int whoBit = (1 << (who - 1));
        final boolean wasStalemated = (stalemated & whoBit) != 0;
        if (wasStalemated && !newStalemated) {
            stalematedHash ^= stalematedHashes[who];
            stalemated &= ~whoBit;
        } else if (!wasStalemated && newStalemated) {
            stalematedHash ^= stalematedHashes[who];
            stalemated |= whoBit;
        }
    }

    /**
     * Clear all stalemates.
     */
    public void clearStalemates() {
        stalematedHash = 0;
        stalemated = 0;
    }

    /**
     * Helper method to convert a given "player index" (i.e. colour) into
     * an "agent index" -- index of the "agent" (might be AI or human) who
     * is currently playing this colour.
     *
     * Normally, this will just return playerIdx again.
     *
     * If players 1 and 2 swapped (e.g. in Hex), it will return an agent index
     * of 1 for player index 2, and agent index of 2 for player index 1. This
     * is because, after swapping, the agent who originally played as Player 1
     * got swapped into playing as Player 2, and the agent who originally
     * played as Player 2 got swapped into playing as Player 1.
     *
     * @param playerIdx
     * @return Index of agent.
     */
    public int playerToAgent(final int playerIdx) {
        // For players >= numPlayers, we just return the given playerIdx
        if (playerIdx >= playerOrder.length)
            return playerIdx;
        // Fast return for what should be by far the most common case
        if (playerOrder[playerIdx] == playerIdx)
            return playerIdx;
        for (int p = 1; p < playerOrder.length; ++p) {
            if (playerOrder[p] == playerIdx)
                return p;
        }
        return Constants.UNDEFINED;
    }

    //-------------------------------------------------------------------------
    /**
     * To reset the state with another.
     *
     * @param other
     * @param game
     */
    public void resetStateTo(final State other, final Game game) {
        // NOTE: these can be copied by reference, because immutable once initialised
        lowScoreHashes = other.lowScoreHashes;
        highScoreHashes = other.highScoreHashes;
        lowAmountHashes = other.lowAmountHashes;
        highAmountHashes = other.highAmountHashes;
        phaseHashes = other.phaseHashes;
        isPendingHashes = other.isPendingHashes;
        lastFromHashes = other.lastFromHashes;
        lastToHashes = other.lastToHashes;
        moverHashes = other.moverHashes;
        nextHashes = other.nextHashes;
        prevHashes = other.prevHashes;
        activeHashes = other.activeHashes;
        checkmatedHashes = other.checkmatedHashes;
        stalematedHashes = other.stalematedHashes;
        tempHashes = other.tempHashes;
        playerOrderHashes = other.playerOrderHashes;
        consecutiveTurnHashes = other.consecutiveTurnHashes;
        playerSwitchHashes = other.playerSwitchHashes;
        teamHashes = other.teamHashes;
        numConsecutivePassesHashCap = other.numConsecutivePassesHashCap;
        numConsecutivePassesHashes = other.numConsecutivePassesHashes;
        playerOrder = Arrays.copyOf(other.playerOrder, other.playerOrder.length);
        moneyPot = other.moneyPot;
        // Back to the plot
        trumpSuit = other.trumpSuit;
        mover = other.mover;
        next = other.next;
        prev = other.prev;
        triggered = other.triggered;
        stalemated = other.stalemated;
        if (other.containerStates == null) {
            containerStates = null;
        } else {
            containerStates = new ContainerState[other.containerStates.length];
            for (int is = 0; is < containerStates.length; is++) if (other.containerStates[is] == null)
                containerStates[is] = null;
            else
                containerStates[is] = other.containerStates[is].deepClone();
        }
        counter = other.counter;
        tempValue = other.tempValue;
        if (other.currentPhase != null)
            currentPhase = Arrays.copyOf(other.currentPhase, other.currentPhase.length);
        numTurnSamePlayer = other.numTurnSamePlayer;
        numTurn = other.numTurn;
        if (other.owned == null)
            owned = null;
        else
            owned = other.owned.copy();
        storedState = other.storedState;
        numConsecutivePasses = other.numConsecutivePasses;
        if (game.isBoardless() && containerStates[0].isEmpty(game.board().topology().centre(SiteType.Cell).get(0).index(), SiteType.Cell))
            containerStates[0].setPlayable(this, game.board().topology().centre(SiteType.Cell).get(0).index(), true);
        isDecided = other.isDecided;
        stateHash = other.stateHash;
        moverHash = other.moverHash;
        nextHash = other.nextHash;
        prevHash = other.prevHash;
        activeHash = other.activeHash;
        checkmatedHash = other.checkmatedHash;
        stalematedHash = other.stalematedHash;
        pendingHash = other.pendingHash;
        scoreHash = other.scoreHash;
        amountHash = other.amountHash;
    }

    //-------------------------------------------------------------------------
    /**
     * Method for copying another OnTrackIndices structure.
     *
     * NOTE: we override this for optimisations in CopyOnWriteState.
     *
     * @param otherOnTrackIndices
     */
    @SuppressWarnings("static-method")
    protected OnTrackIndices copyOnTrackIndices(final OnTrackIndices otherOnTrackIndices) {
        return otherOnTrackIndices == null ? null : new OnTrackIndices(otherOnTrackIndices);
    }

    /**
     * To set on track indices.
     * @param otherOnTrackIndices The on track indices to set.
     */
    public void setOnTrackIndices(final OnTrackIndices otherOnTrackIndices) {
    }

    //-------------------------------------------------------------------------
    /**
     * Initialise this state for use.
     *
     * @param game
     */
    public void initialise(final Game game) {
        moverHash = ZobristHashUtilities.INITIAL_VALUE;
        nextHash = ZobristHashUtilities.INITIAL_VALUE;
        prevHash = ZobristHashUtilities.INITIAL_VALUE;
        activeHash = ZobristHashUtilities.INITIAL_VALUE;
        checkmatedHash = ZobristHashUtilities.INITIAL_VALUE;
        stalematedHash = ZobristHashUtilities.INITIAL_VALUE;
        pendingHash = ZobristHashUtilities.INITIAL_VALUE;
        stateHash = ZobristHashUtilities.INITIAL_VALUE;
        scoreHash = ZobristHashUtilities.INITIAL_VALUE;
        amountHash = ZobristHashUtilities.INITIAL_VALUE;
        mover = 0;
        next = 0;
        prev = 0;
        triggered = 0;
        stalemated = 0;
        moneyPot = 0;
        final int numPlayers = game.players().count();
        if (game.mode().mode() != ModeType.Simulation) {
            setMover(1);
            if (numPlayers > 1)
                setNext(2);
            else
                setNext(1);
            setPrev(0);
        } else {
            setMover(0);
            setNext(0);
            setPrev(0);
        }
        for (final ContainerState is : containerStates) if (is != null)
            is.reset(this, game);
        initPhase(game);
        if (game.usesVote()) {
            isDecided = Constants.UNDEFINED;
        }
    }

    //-------------------------------------------------------------------------
    @Override
    public String toString() {
        String str = "";
        str += "info: mvr=" + mover() + ", nxt=" + next() + ", prv=" + prev() + ".\n";
        str += Arrays.toString(containerStates) + "\n";
        return str;
    }

    //-------------------------------------------------------------------------
    /**
     * @param player
     * @return the amount of a player.
     */
    public int amount(final int player) {
        return 0;
    }

    /**
     * @return the pot.
     */
    public int pot() {
        return moneyPot;
    }

    /**
     * To modify the pot.
     *
     * @param pot The pot value.
     */
    public void setPot(final int pot) {
        moneyPot = pot;
    }

    /**
     * To set a value for a specific player.
     *
     * @param player The player
     * @param value  The value
     */
    public void setValueForPlayer(final int player, final int value) {
    }

    /**
     * @param player The player
     * @return The value of a specific player.
     */
    public int getValue(final int player) {
        return 0;
    }

    /**
     * Add a value to the map.
     *
     * @param key The key of the map.
     * @param value The value.
     */
    public void setValue(final String key, final int value) {
    }

    /**
     * remove a key from the map.
     *
     * @param key The key of the map.
     */
    public void removeKeyValue(final String key) {
    }

    /**
     * @param key The key of the map.
     * @return value for this key, or Constants.OFF if not found
     */
    public int getValue(final String key) {
        return 0;
    }

    /**
     * @return To get the value map.
     */
    public TObjectIntMap<String> getValueMap() {
        return null;
    }

    /**
     * To add a note to the list of note.
     *
     * @param move    The index of the move.
     * @param player  The index of the player.
     * @param message The note to add.
     */
    public void addNote(final int move, final int player, final String message) {
    }

    /**
     * @param move   The index of the move.
     * @param player The index of the player.
     *
     * @return The note of send to a player at a specific move.
     */
    public String getNote(final int move, final int player) {
        return null;
    }

    /**
     * @return the notes.
     */
    public TIntObjectMap<TIntObjectMap<String>> getNotes() {
        return null;
    }

    /**
     * Modify the amount of a player.
     *
     * @param player
     * @param newAmount
     */
    public void setAmount(final int player, final int newAmount) {
    }

    protected void updateAmountHash(final int player) {
    }

    /**
     * Modify the score of a player.
     *
     * WARNING: this should only be called directly from Context!
     *
     * @param player
     * @param score
     * @param scoreArray The array of scores that we wish to modify
     */
    public void setScore(final int player, final int score, final int[] scoreArray) {
        updateScoreHash(player, scoreArray);
        scoreArray[player] = score;
        updateScoreHash(player, scoreArray);
    }

    /**
     * Modify the payoff of a player.
     *
     * WARNING: this should only be called directly from Context!
     *
     * @param player
     * @param payoff
     * @param payoffsArray The array of payoffs that we wish to modify
     */
    @SuppressWarnings("static-method")
    public void setPayoff(final int player, final double payoff, final double[] payoffsArray) {
        payoffsArray[player] = payoff;
    }

    private void updateScoreHash(final int player, final int[] scoreArray) {
        if (// Otherwise, score hashes are not used for this game even if scores are
        lowScoreHashes != null) {
            if (scoreArray[player] > SCORE_MAX_HASH)
                scoreHash ^= highScoreHashes[player][(scoreArray[player]) % SCORE_MAX_HASH];
            else if (scoreArray[player] < 0)
                scoreHash ^= highScoreHashes[player][(-scoreArray[player]) % SCORE_MAX_HASH];
            else
                scoreHash ^= lowScoreHashes[player][scoreArray[player]];
        }
    }

    protected void updatePendingHash(final int pendingVal) {
        final int idx = pendingVal + 1;
        if (idx < isPendingHashes.length)
            pendingHash ^= isPendingHashes[idx];
        else
            pendingHash ^= isPendingHashes[idx % isPendingHashes.length];
    }

    /**
     * Update number of consecutive passes
     * @param lastMoveWasPass
     */
    public void updateNumConsecutivePasses(final boolean lastMoveWasPass) {
        if (lastMoveWasPass)
            ++numConsecutivePasses;
        else
            numConsecutivePasses = 0;
    }

    /**
     * @return Number of consecutive pass moves.
     */
    public int numConsecutivesPasses() {
        return this.numConsecutivePasses;
    }

    /**
     * To set the number of consecutive pass moves.
     * @param numConsecutivesPasses Number of consecutive pass moves.
     */
    public void setNumConsecutivesPasses(final int numConsecutivesPasses) {
        this.numConsecutivePasses = numConsecutivesPasses;
    }

    /**
     * @return Counter.
     */
    public int counter() {
        return counter;
    }

    /**
     * To increment the counter.
     */
    public void incrCounter() {
        counter++;
    }

    /**
     * To decrement the counter.
     */
    public void decrCounter() {
        counter--;
    }

    /**
     * Sets counter.
     * @param counter
     */
    public void setCounter(final int counter) {
        this.counter = counter;
    }

    /**
     * @return tempValue.
     */
    public int temp() {
        return tempValue;
    }

    /**
     * Sets the temp value.
     * @param tempValue
     */
    public void setTemp(final int tempValue) {
        // Allows tempValue to be Off or End
        updateStateHash(tempHashes[this.tempValue + Constants.CONSTANT_RANGE + 1]);
        this.tempValue = tempValue;
        updateStateHash(tempHashes[this.tempValue + Constants.CONSTANT_RANGE + 1]);
    }

    /**
     * @return The pending values.
     */
    public TIntHashSet pendingValues() {
        return null;
    }

    /**
     * @return The propositions.
     */
    public TIntArrayList propositions() {
        return null;
    }

    /**
     * Clear the propositions.
     */
    public void clearPropositions() {
    }

    /**
     * Clear the votes.
     */
    public void clearVotes() {
    }

    /**
     * @return The votes (represented as ints).
     */
    public TIntArrayList votes() {
        return null;
    }

    /**
     * @return The decision of the vote.
     */
    public int isDecided() {
        return isDecided;
    }

    /**
     * To set the decision of the vote.
     *
     * @param isDecided The message.
     */
    public void setIsDecided(final int isDecided) {
        this.isDecided = isDecided;
    }

    /**
     * To add a pending value
     *
     * @param value The value to put in pending.
     */
    public void setPending(final int value) {
        final int pendingValue = (value == Constants.UNDEFINED) ? 1 : value;
        updatePendingHash(pendingValue);
    }

    /**
     * @return True if the state is in pending.
     */
    public boolean isPending() {
        return false;
    }

    /**
     * @param value The value to remove from the pending values
     */
    public void removePendingValue(final int value) {
    }

    /**
     * To clear the pending values
     */
    public void rebootPending() {
    }

    /**
     * To restore the pending values.
     * @param values The pending values.
     */
    public void restorePending(final TIntHashSet values) {
        if (values != null) {
            rebootPending();
            final TIntIterator it = values.iterator();
            while (it.hasNext()) {
                setPending(it.next());
            }
        }
    }

    /**
     * @param indexPlayer
     * @return current index of the phase of a player.
     */
    public int currentPhase(final int indexPlayer) {
        // Matches have null for currentPhase
        return currentPhase != null ? currentPhase[indexPlayer] : 0;
    }

    /**
     * To set the current phase of a player
     * @param indexPlayer
     * @param newPhase
     */
    public void setPhase(final int indexPlayer, final int newPhase) {
        if (phaseHashes != null)
            updateStateHash(phaseHashes[indexPlayer][currentPhase[indexPlayer]]);
        currentPhase[indexPlayer] = newPhase;
        if (phaseHashes != null)
            updateStateHash(phaseHashes[indexPlayer][currentPhase[indexPlayer]]);
    }

    /**
     * To return the sum of the dice of a Dice container.
     *
     * @param index
     * @return Sum of dice
     */
    public int sumDice(final int index) {
        return 0;
    }

    /**
     * For the copy constructor.
     * @return Sum of dice array
     */
    public int[] sumDice() {
        return null;
    }

    /**
     * @param sumDice
     */
    public void setSumDice(final int[] sumDice) {
    }

    /**
     * To reinit the sum of the dice.
     */
    public void reinitSumDice() {
    }

    /**
     * To return the current dice of a Dice container.
     *
     * @param index
     * @return Current dice for (container?) index
     */
    public int[] currentDice(final int index) {
        return null;
    }

    /**
     * To set the boolean diceAllEqual
     *
     * @param value
     */
    public void setDiceAllEqual(final boolean value) {
    }

    /**
     * @return If the dice are all equal when they are rolled.
     */
    public boolean isDiceAllEqual() {
        return false;
    }

    /**
     * For the copy constructor.
     *
     * @return All current dice
     */
    public int[][] currentDice() {
        return null;
    }

    /**
     * @param currentDice
     */
    public void setCurrentDice(final int[][] currentDice) {
    }

    /**
     * To reinit the current dice.
     */
    public void reinitCurrentDice() {
    }

    /**
     * Set the owned structure.
     * @param owned The owned structure.
     */
    public void setOwned(final Owned owned) {
        this.owned = owned.copy();
    }

    /**
     * @return Owned sites per component
     */
    public Owned owned() {
        return owned;
    }

    /**
     * To update the sumDice of the dice container.
     *
     * @param dieValue
     * @param indexHand
     */
    public void updateSumDice(final int dieValue, final int indexHand) {
    }

    /**
     * To update the current dice of the dice container.
     *
     * @param dieValue
     * @param dieIndex
     * @param indexHand
     */
    public void updateCurrentDice(final int dieValue, final int dieIndex, final int indexHand) {
    }

    /**
     * To reinit the visited BitSet.
     */
    public void reInitVisited() {
    }

    /**
     * @param site
     * @return true if the site is already visited
     */
    public boolean isVisited(final int site) {
        return false;
    }

    /**
     * To update the visited bitSet with the site visited.
     *
     * @param site
     */
    public void visit(final int site) {
    }

    /**
     * To unvi the visited bitSet with the site visited.
     *
     * @param site
     */
    public void unvisit(final int site) {
    }

    /**
     * @return visited sites.
     */
    public BitSet visited() {
        return null;
    }

    /**
     * To reinit the visited BitSet.
     */
    public void reInitCapturedPiece() {
    }

    /**
     * To add the site of the piece to remove to the pieceToRemove bitSet.
     *
     * @param site The site of the piece.
     */
    public void addSitesToRemove(final int site) {
    }

    /**
     * To remove the site of the piece to remove from the pieceToRemove bitSet.
     *
     * @param site The site of the piece.
     */
    public void removeSitesToRemove(final int site) {
    }

    /**
     * @return List of sites from which to remove pieces  (e.g. after finishing a sequence of
     * 	capturing hops in International Draughts)
     */
    public TIntArrayList sitesToRemove() {
        return null;
    }

    /**
     * @param pid
     * @param tid
     * @return true if the player pid is in the team tid
     */
    public boolean playerInTeam(final int pid, final int tid) {
        return false;
    }

    /**
     * To put a player in a team
     *
     * @param pid
     * @param tid
     */
    public void setPlayerToTeam(final int pid, final int tid) {
    }

    /**
     * @param pid
     * @return The index of the team of the player pid
     */
    public int getTeam(final int pid) {
        return 0;
    }

    /**
     * All the pieces to remove.
     *
     * @return Region containing all sites to remove
     */
    public Region regionToRemove() {
        return new Region();
    }

    /**
     * @return sameTurnPlayed.
     */
    public int numTurnSamePlayer() {
        return numTurnSamePlayer;
    }

    /**
     * To reinit the number of turn played by the same player
     */
    public void reinitNumTurnSamePlayer() {
        numTurnSamePlayer = 0;
        ++numTurn;
    }

    /**
     * @param numTurnSamePlayer The number of moves of the same player so far in the turn.
     */
    public void setTurnSamePlayer(final int numTurnSamePlayer) {
        this.numTurnSamePlayer = numTurnSamePlayer;
    }

    /**
     * to increment the number of turn played by the same player
     */
    public void incrementNumTurnSamePlayer() {
        numTurnSamePlayer++;
    }

    /**
     * @return How often did we switch over to a new player as mover?
     */
    public int numTurn() {
        return numTurn;
    }

    /**
     * @param numTurn The number of turns.
     */
    public void setNumTurn(final int numTurn) {
        this.numTurn = numTurn;
    }

    //-------------------------------------------------------------------------
    @Override
    public boolean equals(final Object other) {
        if (!(other instanceof State)) {
            return false;
        }
        final State otherState = (State) other;
        return fullHash() == otherState.fullHash();
    }

    @Override
    public int hashCode() {
        // Bottom 32 bits of full hash
        return (int) (fullHash() & 0xFF_FF_FF_FF);
    }

    /**
     * To init the phase of the initial state.
     *
     * @param game
     */
    public void initPhase(final Game game) {
        if (game.rules() != null && game.rules().phases() != null) {
            currentPhase = new int[game.players().count() + 1];
            for (int pid = 1; pid <= game.players().count(); pid++) {
                for (int indexPhase = 0; indexPhase < game.rules().phases().length; indexPhase++) {
                    final Phase phase = game.rules().phases()[indexPhase];
                    final RoleType roleType = phase.owner();
                    if (roleType == null)
                        continue;
                    final int phaseOwner = roleType.owner();
                    if (phaseOwner == pid || roleType == RoleType.Shared) {
                        currentPhase[pid] = indexPhase;
                        break;
                    }
                }
            }
            //			System.out.println("INIT PHASES:");
            //			for (int i = 1; i <= currentPhase.length; i++)
            //				System.out.println("Player " + i + " Phase = " + currentPhase[i - 1]);
        }
    }

    /**
     * @return The current suit trump.
     */
    public int trumpSuit() {
        return trumpSuit;
    }

    /**
     * To set the trump suit.
     *
     * @param trumpSuit
     */
    public void setTrumpSuit(final int trumpSuit) {
        this.trumpSuit = trumpSuit;
    }

    /**
     * @return The structure to get the indices of each element on the track.
     */
    public OnTrackIndices onTrackIndices() {
        return null;
    }

    //-------------------------------------------------------------------------
    /**
     * To swap the player in the list.
     *
     * @param player1 The first player.
     * @param player2 The second player.
     */
    public void swapPlayerOrder(final int player1, final int player2) {
        int currentIndex1 = 0, currentindex2 = 0;
        for (int i = 1; i < playerOrder.length; i++) {
            if (playerOrder[i] == player1)
                currentIndex1 = i;
            if (playerOrder[i] == player2)
                currentindex2 = i;
        }
        final int temp = playerOrder[currentIndex1];
        updateStateHash(playerOrderHashes[currentIndex1][playerOrder[currentIndex1]]);
        playerOrder[currentIndex1] = playerOrder[currentindex2];
        updateStateHash(playerOrderHashes[currentIndex1][playerOrder[currentIndex1]]);
        updateStateHash(playerOrderHashes[currentindex2][playerOrder[currentindex2]]);
        playerOrder[currentindex2] = temp;
        updateStateHash(playerOrderHashes[currentindex2][playerOrder[currentindex2]]);
    }

    /**
     * @param playerId The player.
     * @return The index in the order of a player.
     */
    public int currentPlayerOrder(final int playerId) {
        return playerOrder[playerId];
    }

    /**
     * @param playerId The player.
     * @return The index of the player in the original order.
     */
    public int originalPlayerOrder(final int playerId) {
        for (int p = 1; p < playerOrder.length; p++) if (playerOrder[p] == playerId)
            return p;
        for (int po = 0; po < playerOrder.length; po++) System.out.println("playerOrder[" + po + "] = " + playerOrder[po]);
        throw new RuntimeException("Player " + playerId + " has disappeared after swapping!");
        //return Constants.UNDEFINED;
    }

    /**
     * @return True if the order has changed.
     */
    public boolean orderHasChanged() {
        for (int p = 1; p < playerOrder.length; p++) if (playerOrder[p] != p)
            return true;
        return false;
    }

    //-------------------------------------------------------------------------
    /**
     * @return The remaining dominoes
     */
    public FastTIntArrayList remainingDominoes() {
        return null;
    }

    //-------------------------------------------------------------------------
    /**
     * @return The values stored in previous states.
     */
    public FastTIntArrayList rememberingValues() {
        return null;
    }

    /**
     * @return The values stored in previous states and associated to a name.
     */
    public Map<String, FastTIntArrayList> mapRememberingValues() {
        return null;
    }

    //-------------------------------------------------------------------------
    /**
     * @return The state stored in the game.
     */
    public long storedState() {
        return storedState;
    }

    /**
     * To store a state of the game
     *
     * @param state The state to store.
     */
    public void storeCurrentState(final State state) {
        storedState = state.stateHash();
    }

    /**
     * To restore a state of the game
     *
     * @param value The state hash value to restore.
     */
    public void restoreCurrentState(final long value) {
        storedState = value;
    }

    //-------------------------------------------------------------------------
    /**
     * @param context The current context.
     * @return The concepts involved in this specific state.
     */
    @SuppressWarnings("static-method")
    public BitSet concepts(final Context context) {
        // TODO CHECK LEGAL MOVES CONCEPT, CHECK ONLY PIECES CONCEPT ON BOARD, BUT NEED TO DISCUSS WITH MATTHEW BEFORE TO FINISH THAT CODE.
        final Game game = context.game();
        final BitSet concepts = new BitSet();
        // Accumulate concepts over the players.
        concepts.or(game.players().concepts(game));
        // Accumulate concepts for all the containers.
        for (int i = 0; i < game.equipment().containers().length; i++) concepts.or(game.equipment().containers()[i].concepts(game));
        // Accumulate concepts for all the components.
        for (int i = 1; i < game.equipment().components().length; i++) concepts.or(game.equipment().components()[i].concepts(game));
        //		// Accumulate concepts for all the regions.
        //		for (int i = 0; i < equipment().regions().length; i++)
        //			concept.or(equipment().regions()[i].concepts(this));
        //
        //		// Accumulate concepts for all the maps.
        //		for (int i = 0; i < equipment().maps().length; i++)
        //			concept.or(equipment().maps()[i].concepts(this));
        //
        //		// Look if the game uses hints.
        //		if (equipment().vertexHints().length != 0 || equipment().cellsWithHints().length != 0
        //			|| equipment().edgesWithHints().length != 0)
        //			concept.set(Concept.Hints.id(), true);
        //
        //		// Check if some regions are defined.
        //		if (equipment().regions().length != 0)
        //			concept.set(Concept.Region.id(), true);
        //
        //		// Accumulate concepts over meta rules
        //		if (rules.meta() != null)
        //			for (final MetaRule meta : rules.meta().rules())
        //				concept.or(meta.concepts(this));
        //
        //		// Accumulate concepts over the ending rules.
        //		if (rules.end() != null)
        //			concept.or(rules.end().concepts(this));
        //
        //		// Look if the game uses a stack state.
        //		if (isStacking())
        //		{
        //			concept.set(Concept.StackState.id(), true);
        //			concept.set(Concept.Stack.id(), true);
        //		}
        //
        //		// Look the graph element types used.
        //		concept.or(SiteType.concepts(board().defaultSite()));
        return concepts;
    }

    public abstract State copy();
}
