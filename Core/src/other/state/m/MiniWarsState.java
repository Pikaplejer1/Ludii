package other.state.m;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for MiniWars. */
public class MiniWarsState extends State {

    private static final long serialVersionUID = 1L;

    private int[] teams = null;
    private gnu.trove.list.array.TIntArrayList sitesToRemove = new gnu.trove.list.array.TIntArrayList();
    private java.util.Map<String, main.collections.FastTIntArrayList> mapRememberingValues = new java.util.HashMap<>();
    private main.collections.FastTIntArrayList rememberingValues = new main.collections.FastTIntArrayList();
    private gnu.trove.map.TObjectIntMap<String> valueMap = new gnu.trove.map.hash.TObjectIntHashMap<>();

    public MiniWarsState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
        if (game.requiresTeams()) teams = new int[game.players().size()];
    }

    public MiniWarsState(final MiniWarsState other) {
        super(other);
        if (other.teams != null) teams = java.util.Arrays.copyOf(other.teams, other.teams.length);
        sitesToRemove = (other.sitesToRemove != null) ? new gnu.trove.list.array.TIntArrayList(other.sitesToRemove) : new gnu.trove.list.array.TIntArrayList();
        if (other.mapRememberingValues != null) {
            mapRememberingValues = new java.util.HashMap<>();
            for (var e : other.mapRememberingValues.entrySet())
                mapRememberingValues.put(e.getKey(), new main.collections.FastTIntArrayList(e.getValue()));
        } else { mapRememberingValues = new java.util.HashMap<>(); }
        rememberingValues = (other.rememberingValues != null) ? new main.collections.FastTIntArrayList(other.rememberingValues) : new main.collections.FastTIntArrayList();
        valueMap = (other.valueMap != null) ? new gnu.trove.map.hash.TObjectIntHashMap<>(other.valueMap) : new gnu.trove.map.hash.TObjectIntHashMap<>();
    }

    @Override public MiniWarsState copy() { return new MiniWarsState(this); }

    @Override public void resetStateTo(final State other, final Game game) {
        super.resetStateTo(other, game);
        final MiniWarsState o = (MiniWarsState) other;
        if (o.teams != null) teams = java.util.Arrays.copyOf(o.teams, o.teams.length);
        sitesToRemove = (o.sitesToRemove != null) ? new gnu.trove.list.array.TIntArrayList(o.sitesToRemove) : new gnu.trove.list.array.TIntArrayList();
        if (o.mapRememberingValues != null) {
            mapRememberingValues = new java.util.HashMap<>();
            for (var e : o.mapRememberingValues.entrySet())
                mapRememberingValues.put(e.getKey(), new main.collections.FastTIntArrayList(e.getValue()));
        } else { mapRememberingValues = new java.util.HashMap<>(); }
        rememberingValues = (o.rememberingValues != null) ? new main.collections.FastTIntArrayList(o.rememberingValues) : new main.collections.FastTIntArrayList();
        valueMap = (o.valueMap != null) ? new gnu.trove.map.hash.TObjectIntHashMap<>(o.valueMap) : new gnu.trove.map.hash.TObjectIntHashMap<>();
    }

    @Override public void initialise(final Game game) {
        super.initialise(game);
        if (teams != null) for (int i = 1; i < teams.length; i++) teams[i] = i;
        sitesToRemove.clear();
        mapRememberingValues.clear();
        valueMap.clear();
    }

    @Override public boolean playerInTeam(final int pid, final int tid) { return (teams != null && pid < teams.length) && teams[pid] == tid; }
    @Override public void setPlayerToTeam(final int pid, final int tid) {
        if (teamHashes != null) updateStateHash(teamHashes[pid][teams[pid]]);
        teams[pid] = tid;
        if (teamHashes != null) updateStateHash(teamHashes[pid][teams[pid]]);
    }
    @Override public int getTeam(final int pid) { return (teams == null || pid >= teams.length) ? main.Constants.UNDEFINED : teams[pid]; }

    @Override public void reInitCapturedPiece() { sitesToRemove.clear(); }
    @Override public void addSitesToRemove(final int site) { sitesToRemove.add(site); }
    @Override public void removeSitesToRemove(final int site) { sitesToRemove.remove(site); }
    @Override public gnu.trove.list.array.TIntArrayList sitesToRemove() { return sitesToRemove; }
    @Override public game.util.equipment.Region regionToRemove() {
        return new game.util.equipment.Region(sitesToRemove.toArray());
    }

    @Override public java.util.Map<String, main.collections.FastTIntArrayList> mapRememberingValues() { return mapRememberingValues; }

    @Override public main.collections.FastTIntArrayList rememberingValues() { return rememberingValues; }

    @Override public void setValue(final String key, final int value) { valueMap.put(key, value); }
    @Override public void removeKeyValue(final String key) { valueMap.remove(key); }
    @Override public int getValue(final String key) { return valueMap.containsKey(key) ? valueMap.get(key) : main.Constants.OFF; }
    @Override public gnu.trove.map.TObjectIntMap<String> getValueMap() { return valueMap; }

}
