package other.state.d;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Damas. */
public class DamasState extends State {

    private static final long serialVersionUID = 1L;

    private gnu.trove.set.hash.TIntHashSet pendingValues = new gnu.trove.set.hash.TIntHashSet();
    private gnu.trove.list.array.TIntArrayList sitesToRemove = new gnu.trove.list.array.TIntArrayList();
    private java.util.Map<String, main.collections.FastTIntArrayList> mapRememberingValues = new java.util.HashMap<>();
    private main.collections.FastTIntArrayList rememberingValues = new main.collections.FastTIntArrayList();
    private gnu.trove.map.TObjectIntMap<String> valueMap = new gnu.trove.map.hash.TObjectIntHashMap<>();

    public DamasState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public DamasState(final DamasState other) {
        super(other);
        pendingValues = (other.pendingValues != null) ? new gnu.trove.set.hash.TIntHashSet(other.pendingValues) : new gnu.trove.set.hash.TIntHashSet();
        sitesToRemove = (other.sitesToRemove != null) ? new gnu.trove.list.array.TIntArrayList(other.sitesToRemove) : new gnu.trove.list.array.TIntArrayList();
        if (other.mapRememberingValues != null) {
            mapRememberingValues = new java.util.HashMap<>();
            for (var e : other.mapRememberingValues.entrySet())
                mapRememberingValues.put(e.getKey(), new main.collections.FastTIntArrayList(e.getValue()));
        } else { mapRememberingValues = new java.util.HashMap<>(); }
        rememberingValues = (other.rememberingValues != null) ? new main.collections.FastTIntArrayList(other.rememberingValues) : new main.collections.FastTIntArrayList();
        valueMap = (other.valueMap != null) ? new gnu.trove.map.hash.TObjectIntHashMap<>(other.valueMap) : new gnu.trove.map.hash.TObjectIntHashMap<>();
    }

    @Override public DamasState copy() { return new DamasState(this); }

    @Override public void resetStateTo(final State other, final Game game) {
        super.resetStateTo(other, game);
        final DamasState o = (DamasState) other;
        pendingValues = (o.pendingValues != null) ? new gnu.trove.set.hash.TIntHashSet(o.pendingValues) : new gnu.trove.set.hash.TIntHashSet();
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
        pendingValues.clear();
        sitesToRemove.clear();
        mapRememberingValues.clear();
        valueMap.clear();
    }

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
