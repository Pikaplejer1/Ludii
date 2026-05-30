package other.state.a;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for AsiKeliya. */
public class AsiKeliyaState extends State {

    private static final long serialVersionUID = 1L;

    private int[] sumDice = new int[0];
    private int[][] currentDice = new int[0][];
    private boolean diceAllEqual = false;
    private int[] teams = null;
    private gnu.trove.set.hash.TIntHashSet pendingValues = new gnu.trove.set.hash.TIntHashSet();
    private transient other.state.track.OnTrackIndices onTrackIndices;

    public AsiKeliyaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
        if (game.hasHandDice() && game.handDice() != null) sumDice = new int[game.handDice().size()];
        if (game.hasHandDice() && game.handDice() != null) {
            currentDice = new int[game.handDice().size()][];
            for (int i = 0; i < game.handDice().size(); i++) {
                final game.equipment.container.other.Dice d = game.handDice().get(i);
                currentDice[i] = new int[d.numLocs()];
            }
        }
        if (game.requiresTeams()) teams = new int[game.players().size()];
        if (game.hasTrack() && game.hasInternalLoopInTrack())
            onTrackIndices = new other.state.track.OnTrackIndices(game.board().tracks(), game.equipment().components().length);
    }

    public AsiKeliyaState(final AsiKeliyaState other) {
        super(other);
        if (other.sumDice != null) sumDice = java.util.Arrays.copyOf(other.sumDice, other.sumDice.length);
        if (other.currentDice != null) {
            currentDice = new int[other.currentDice.length][];
            for (int i = 0; i < currentDice.length; ++i)
                currentDice[i] = java.util.Arrays.copyOf(other.currentDice[i], other.currentDice[i].length);
        }
        diceAllEqual = other.diceAllEqual;
        if (other.teams != null) teams = java.util.Arrays.copyOf(other.teams, other.teams.length);
        pendingValues = (other.pendingValues != null) ? new gnu.trove.set.hash.TIntHashSet(other.pendingValues) : new gnu.trove.set.hash.TIntHashSet();
        onTrackIndices = copyOnTrackIndices(other.onTrackIndices);
    }

    @Override public AsiKeliyaState copy() { return new AsiKeliyaState(this); }

    @Override public void resetStateTo(final State other, final Game game) {
        super.resetStateTo(other, game);
        final AsiKeliyaState o = (AsiKeliyaState) other;
        if (o.sumDice != null) sumDice = java.util.Arrays.copyOf(o.sumDice, o.sumDice.length);
        if (o.currentDice != null) {
            currentDice = new int[o.currentDice.length][];
            for (int i = 0; i < currentDice.length; ++i)
                currentDice[i] = java.util.Arrays.copyOf(o.currentDice[i], o.currentDice[i].length);
        }
        diceAllEqual = o.diceAllEqual;
        if (o.teams != null) teams = java.util.Arrays.copyOf(o.teams, o.teams.length);
        pendingValues = (o.pendingValues != null) ? new gnu.trove.set.hash.TIntHashSet(o.pendingValues) : new gnu.trove.set.hash.TIntHashSet();
        onTrackIndices = copyOnTrackIndices(o.onTrackIndices);
    }

    @Override public void initialise(final Game game) {
        super.initialise(game);
        if (game.hasHandDice() && game.handDice() != null) sumDice = new int[game.handDice().size()];
        if (game.hasHandDice() && game.handDice() != null) {
            currentDice = new int[game.handDice().size()][];
            for (int i = 0; i < game.handDice().size(); i++) {
                final game.equipment.container.other.Dice d = game.handDice().get(i);
                currentDice[i] = new int[d.numLocs()];
            }
        }
        diceAllEqual = false;
        if (teams != null) for (int i = 1; i < teams.length; i++) teams[i] = i;
        pendingValues.clear();
        if (game.hasTrack() && game.hasInternalLoopInTrack())
            onTrackIndices = new other.state.track.OnTrackIndices(game.board().tracks(), game.equipment().components().length);
    }

    @Override public int sumDice(final int index) { return sumDice[index]; }
    @Override public int[] sumDice() { return sumDice; }
    @Override public void setSumDice(final int[] sumDice) { this.sumDice = (sumDice != null) ? sumDice : new int[0]; }
    @Override public void reinitSumDice() { for (int i = 0; i < sumDice.length; i++) sumDice[i] = 0; }
    @Override public void updateSumDice(final int dieValue, final int indexHand) { sumDice[indexHand] += dieValue; }

    @Override public int[] currentDice(final int index) { return currentDice[index]; }
    @Override public int[][] currentDice() { return currentDice; }
    @Override public void setCurrentDice(final int[][] currentDice) { this.currentDice = (currentDice != null) ? currentDice : new int[0][]; }
    @Override public void reinitCurrentDice() { for (int i = 0; i < currentDice.length; i++) for (int j = 0; j < currentDice[i].length; j++) currentDice[i][j] = 0; }
    @Override public void updateCurrentDice(final int dieValue, final int dieIndex, final int indexHand) { currentDice[indexHand][dieIndex] = dieValue; }

    @Override public void setDiceAllEqual(final boolean value) { diceAllEqual = value; }
    @Override public boolean isDiceAllEqual() { return diceAllEqual; }

    @Override public boolean playerInTeam(final int pid, final int tid) { return (teams != null && pid < teams.length) && teams[pid] == tid; }
    @Override public void setPlayerToTeam(final int pid, final int tid) {
        if (teamHashes != null) updateStateHash(teamHashes[pid][teams[pid]]);
        teams[pid] = tid;
        if (teamHashes != null) updateStateHash(teamHashes[pid][teams[pid]]);
    }
    @Override public int getTeam(final int pid) { return (teams == null || pid >= teams.length) ? main.Constants.UNDEFINED : teams[pid]; }

    @Override public gnu.trove.set.hash.TIntHashSet pendingValues() { return pendingValues; }
    @Override public void setPending(final int value) {
        super.setPending(value);
        final int pv = (value == main.Constants.UNDEFINED) ? 1 : value;
        pendingValues.add(pv);
    }
    @Override public boolean isPending() { return !pendingValues.isEmpty(); }
    @Override public void removePendingValue(final int value) { pendingValues.remove(value); }
    @Override public void rebootPending() {
        final gnu.trove.iterator.TIntIterator it = pendingValues.iterator();
        while (it.hasNext()) updatePendingHash(it.next());
        pendingValues.clear();
    }
    @Override public void restorePending(final gnu.trove.set.hash.TIntHashSet values) {
        if (values != null) { rebootPending(); final gnu.trove.iterator.TIntIterator it = values.iterator(); while (it.hasNext()) setPending(it.next()); }
    }

    @Override public other.state.track.OnTrackIndices onTrackIndices() { return onTrackIndices; }
    @Override public void setOnTrackIndices(final other.state.track.OnTrackIndices oti) {
        this.onTrackIndices = (oti == null) ? null : new other.state.track.OnTrackIndices(oti);
    }

}
