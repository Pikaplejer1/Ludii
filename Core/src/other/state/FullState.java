package other.state;

import game.Game;
import game.Game.StateConstructorLock;

/** Auto-generated State subclass for Full. */
public class FullState extends State {

    private static final long serialVersionUID = 1L;

    private int[] valuesPlayer;
    private gnu.trove.list.array.TIntArrayList votes;
    private int[] amount = null;
    private java.util.Map<String, main.collections.FastTIntArrayList> mapRememberingValues = null;
    private gnu.trove.map.TObjectIntMap<String> valueMap = null;
    private main.collections.FastTIntArrayList rememberingValues;
    private gnu.trove.list.array.TIntArrayList sitesToRemove = null;
    private gnu.trove.list.array.TIntArrayList propositions;
    private gnu.trove.map.TIntObjectMap<gnu.trove.map.TIntObjectMap<String>> notes = null;
    private int[][] currentDice;
    private transient other.state.track.OnTrackIndices onTrackIndices;
    private main.collections.FastTIntArrayList remainingDominoes;
    private java.util.BitSet visited = null;
    private boolean diceAllEqual = false;
    private gnu.trove.set.hash.TIntHashSet pendingValues = null;
    private int[] teams = null;
    private int[] sumDice;

    public FullState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
        valuesPlayer = new int[game.players().size() + 1];
        java.util.Arrays.fill(valuesPlayer, main.Constants.UNDEFINED);
        votes = game.usesVote() ? new gnu.trove.list.array.TIntArrayList() : null;
        if (game.requiresBet()) amount = new int[game.players().count() + 1];
        if (game.usesRememberingValues()) mapRememberingValues = new java.util.HashMap<>();
        if (game.usesValueMap()) valueMap = new gnu.trove.map.hash.TObjectIntHashMap<>();
        rememberingValues = new main.collections.FastTIntArrayList();
        if (game.hasSequenceCapture()) sitesToRemove = new gnu.trove.list.array.TIntArrayList();
        propositions = game.usesVote() ? new gnu.trove.list.array.TIntArrayList() : null;
        if (game.usesNote()) notes = new gnu.trove.map.hash.TIntObjectHashMap<>();
        if (game.hasHandDice()) {
            currentDice = new int[game.handDice().size()][];
            for (int i = 0; i < game.handDice().size(); i++) {
                final game.equipment.container.other.Dice d = game.handDice().get(i);
                currentDice[i] = new int[d.numLocs()];
            }
        }
        if (game.hasTrack() && game.hasInternalLoopInTrack())
            onTrackIndices = new other.state.track.OnTrackIndices(game.board().tracks(), game.equipment().components().length);
        if (game.hasDominoes()) remainingDominoes = new main.collections.FastTIntArrayList();
        if (game.requiresVisited()) visited = new java.util.BitSet(game.board().numSites());
        if (game.usesPendingValues()) pendingValues = new gnu.trove.set.hash.TIntHashSet();
        if (game.requiresTeams()) teams = new int[game.players().size()];
        if (game.hasHandDice()) sumDice = new int[game.handDice().size()];
    }

    public FullState(final FullState other) {
        super(other);
        valuesPlayer = new int[other.valuesPlayer.length];
        System.arraycopy(other.valuesPlayer, 0, valuesPlayer, 0, other.valuesPlayer.length);
        votes = (other.votes != null) ? new gnu.trove.list.array.TIntArrayList(other.votes) : null;
        if (other.amount != null) amount = java.util.Arrays.copyOf(other.amount, other.amount.length);
        if (other.mapRememberingValues != null) {
            mapRememberingValues = new java.util.HashMap<>();
            for (var e : other.mapRememberingValues.entrySet())
                mapRememberingValues.put(e.getKey(), new main.collections.FastTIntArrayList(e.getValue()));
        }
        if (other.valueMap != null) valueMap = new gnu.trove.map.hash.TObjectIntHashMap<>(other.valueMap);
        if (other.rememberingValues != null) rememberingValues = new main.collections.FastTIntArrayList(other.rememberingValues);
        if (other.sitesToRemove != null) sitesToRemove = new gnu.trove.list.array.TIntArrayList(other.sitesToRemove);
        propositions = (other.propositions != null) ? new gnu.trove.list.array.TIntArrayList(other.propositions) : null;
        if (other.notes != null) notes = new gnu.trove.map.hash.TIntObjectHashMap<>(other.notes);
        if (other.currentDice != null) {
            currentDice = new int[other.currentDice.length][];
            for (int i = 0; i < currentDice.length; ++i)
                currentDice[i] = java.util.Arrays.copyOf(other.currentDice[i], other.currentDice[i].length);
        }
        onTrackIndices = copyOnTrackIndices(other.onTrackIndices);
        if (other.remainingDominoes != null) remainingDominoes = new main.collections.FastTIntArrayList(other.remainingDominoes);
        if (other.visited != null) visited = (java.util.BitSet) other.visited.clone();
        diceAllEqual = other.diceAllEqual;
        if (other.pendingValues != null) pendingValues = new gnu.trove.set.hash.TIntHashSet(other.pendingValues);
        if (other.teams != null) teams = java.util.Arrays.copyOf(other.teams, other.teams.length);
        if (other.sumDice != null) sumDice = java.util.Arrays.copyOf(other.sumDice, other.sumDice.length);
    }

    @Override public FullState copy() { return new FullState(this); }

    @Override public void resetStateTo(final State other, final Game game) {
        super.resetStateTo(other, game);
        final FullState o = (FullState) other;
        valuesPlayer = new int[o.valuesPlayer.length];
        System.arraycopy(o.valuesPlayer, 0, valuesPlayer, 0, o.valuesPlayer.length);
        votes = (o.votes != null) ? new gnu.trove.list.array.TIntArrayList(o.votes) : null;
        if (o.amount != null) amount = java.util.Arrays.copyOf(o.amount, o.amount.length);
        if (o.mapRememberingValues != null) {
            mapRememberingValues = new java.util.HashMap<>();
            for (var e : o.mapRememberingValues.entrySet())
                mapRememberingValues.put(e.getKey(), new main.collections.FastTIntArrayList(e.getValue()));
        }
        if (o.valueMap != null) valueMap = new gnu.trove.map.hash.TObjectIntHashMap<>(o.valueMap);
        if (o.rememberingValues != null) rememberingValues = new main.collections.FastTIntArrayList(o.rememberingValues);
        if (o.sitesToRemove != null) sitesToRemove = new gnu.trove.list.array.TIntArrayList(o.sitesToRemove);
        propositions = (o.propositions != null) ? new gnu.trove.list.array.TIntArrayList(o.propositions) : null;
        if (o.notes != null) notes = new gnu.trove.map.hash.TIntObjectHashMap<>(o.notes);
        if (o.currentDice != null) {
            currentDice = new int[o.currentDice.length][];
            for (int i = 0; i < currentDice.length; ++i)
                currentDice[i] = java.util.Arrays.copyOf(o.currentDice[i], o.currentDice[i].length);
        }
        onTrackIndices = copyOnTrackIndices(o.onTrackIndices);
        if (o.remainingDominoes != null) remainingDominoes = new main.collections.FastTIntArrayList(o.remainingDominoes);
        if (o.visited != null) visited = (java.util.BitSet) o.visited.clone();
        diceAllEqual = o.diceAllEqual;
        if (o.pendingValues != null) pendingValues = new gnu.trove.set.hash.TIntHashSet(o.pendingValues);
        if (o.teams != null) teams = java.util.Arrays.copyOf(o.teams, o.teams.length);
        if (o.sumDice != null) sumDice = java.util.Arrays.copyOf(o.sumDice, o.sumDice.length);
    }

    @Override public void initialise(final Game game) {
        super.initialise(game);
        java.util.Arrays.fill(valuesPlayer, main.Constants.UNDEFINED);
        if (votes != null) votes.clear();
        if (amount != null) for (int i = 0; i < amount.length; i++) amount[i] = 0;
        if (propositions != null) propositions.clear();
        if (game.usesNote()) notes = new gnu.trove.map.hash.TIntObjectHashMap<>();
        diceAllEqual = false;
        if (teams != null) for (int i = 1; i < teams.length; i++) teams[i] = i;
    }

    @Override public void setValueForPlayer(final int player, final int value) { valuesPlayer[player] = value; }
    @Override public int getValue(final int player) { return valuesPlayer[player]; }

    @Override public gnu.trove.list.array.TIntArrayList votes() { return votes; }
    @Override public void clearVotes() { if (votes != null) votes.clear(); }

    @Override public int amount(final int player) { return (amount != null) ? amount[player] : 0; }
    @Override public void setAmount(final int player, final int newAmount) {
        if (amount != null && player > 0 && player < amount.length) amount[player] = newAmount;
    }
    @Override protected void updateAmountHash(final int player) {
        if (lowAmountHashes != null) {
            if (amount[player] <= AMOUNT_MAX_HASH)
                amountHash ^= lowAmountHashes[player][amount[player]];
            else
                amountHash ^= highAmountHashes[player][amount[player] % AMOUNT_MAX_HASH];
        }
    }

    @Override public java.util.Map<String, main.collections.FastTIntArrayList> mapRememberingValues() { return mapRememberingValues; }

    @Override public void setValue(final String key, final int value) { if (valueMap != null) valueMap.put(key, value); }
    @Override public void removeKeyValue(final String key) { if (valueMap != null) valueMap.remove(key); }
    @Override public int getValue(final String key) { return (valueMap == null || !valueMap.containsKey(key)) ? main.Constants.OFF : valueMap.get(key); }
    @Override public gnu.trove.map.TObjectIntMap<String> getValueMap() { return valueMap; }

    @Override public main.collections.FastTIntArrayList rememberingValues() { return rememberingValues; }

    @Override public void reInitCapturedPiece() { if (sitesToRemove != null) sitesToRemove.clear(); }
    @Override public void addSitesToRemove(final int site) { if (sitesToRemove != null) sitesToRemove.add(site); }
    @Override public void removeSitesToRemove(final int site) { if (sitesToRemove != null) sitesToRemove.remove(site); }
    @Override public gnu.trove.list.array.TIntArrayList sitesToRemove() { return sitesToRemove; }
    @Override public game.util.equipment.Region regionToRemove() {
        return (sitesToRemove == null) ? new game.util.equipment.Region() : new game.util.equipment.Region(sitesToRemove.toArray());
    }

    @Override public gnu.trove.list.array.TIntArrayList propositions() { return propositions; }
    @Override public void clearPropositions() { if (propositions != null) propositions.clear(); }

    @Override public void addNote(final int move, final int player, final String message) {
        if (notes == null) return;
        if (notes.get(move) == null) notes.put(move, new gnu.trove.map.hash.TIntObjectHashMap<>());
        notes.get(move).put(player, message);
    }
    @Override public String getNote(final int move, final int player) {
        if (notes == null) return null;
        final gnu.trove.map.TIntObjectMap<String> nfm = notes.get(move);
        return (nfm == null) ? null : nfm.get(player);
    }
    @Override public gnu.trove.map.TIntObjectMap<gnu.trove.map.TIntObjectMap<String>> getNotes() { return notes; }

    @Override public int[] currentDice(final int index) { return currentDice[index]; }
    @Override public int[][] currentDice() { return currentDice; }
    @Override public void setCurrentDice(final int[][] currentDice) { this.currentDice = currentDice; }
    @Override public void reinitCurrentDice() { for (int i = 0; i < currentDice.length; i++) for (int j = 0; j < currentDice[i].length; j++) currentDice[i][j] = 0; }
    @Override public void updateCurrentDice(final int dieValue, final int dieIndex, final int indexHand) { currentDice[indexHand][dieIndex] = dieValue; }

    @Override public other.state.track.OnTrackIndices onTrackIndices() { return onTrackIndices; }
    @Override public void setOnTrackIndices(final other.state.track.OnTrackIndices oti) {
        this.onTrackIndices = (oti == null) ? null : new other.state.track.OnTrackIndices(oti);
    }

    @Override public main.collections.FastTIntArrayList remainingDominoes() { return remainingDominoes; }

    @Override public void reInitVisited() { if (visited != null) visited.clear(); }
    @Override public boolean isVisited(final int site) { return visited != null && visited.get(site); }
    @Override public void visit(final int site) { if (visited != null && visited.size() > site && site >= 0) visited.set(site, true); }
    @Override public void unvisit(final int site) { if (visited != null && visited.size() > site && site >= 0) visited.set(site, false); }
    @Override public java.util.BitSet visited() { return visited; }

    @Override public void setDiceAllEqual(final boolean value) { diceAllEqual = value; }
    @Override public boolean isDiceAllEqual() { return diceAllEqual; }

    @Override public gnu.trove.set.hash.TIntHashSet pendingValues() { return pendingValues; }
    @Override public void setPending(final int value) {
        super.setPending(value);
        final int pv = (value == main.Constants.UNDEFINED) ? 1 : value;
        if (pendingValues != null) pendingValues.add(pv);
    }
    @Override public boolean isPending() { return pendingValues != null && !pendingValues.isEmpty(); }
    @Override public void removePendingValue(final int value) { if (pendingValues != null) pendingValues.remove(value); }
    @Override public void rebootPending() {
        if (pendingValues != null) {
            final gnu.trove.iterator.TIntIterator it = pendingValues.iterator();
            while (it.hasNext()) updatePendingHash(it.next());
            pendingValues.clear();
        }
    }
    @Override public void restorePending(final gnu.trove.set.hash.TIntHashSet values) {
        if (values != null) { rebootPending(); final gnu.trove.iterator.TIntIterator it = values.iterator(); while (it.hasNext()) setPending(it.next()); }
    }

    @Override public boolean playerInTeam(final int pid, final int tid) { return (teams != null && pid < teams.length) && teams[pid] == tid; }
    @Override public void setPlayerToTeam(final int pid, final int tid) {
        if (teamHashes != null) updateStateHash(teamHashes[pid][teams[pid]]);
        teams[pid] = tid;
        if (teamHashes != null) updateStateHash(teamHashes[pid][teams[pid]]);
    }
    @Override public int getTeam(final int pid) { return (teams == null || pid >= teams.length) ? main.Constants.UNDEFINED : teams[pid]; }

    @Override public int sumDice(final int index) { return sumDice[index]; }
    @Override public int[] sumDice() { return sumDice; }
    @Override public void setSumDice(final int[] sumDice) { this.sumDice = sumDice; }
    @Override public void reinitSumDice() { for (int i = 0; i < sumDice.length; i++) sumDice[i] = 0; }
    @Override public void updateSumDice(final int dieValue, final int indexHand) { sumDice[indexHand] += dieValue; }

}
