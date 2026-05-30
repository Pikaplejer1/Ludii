package other.state.p;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Pippinzip. */
public class PippinzipState extends State {

    private static final long serialVersionUID = 1L;

    private gnu.trove.map.TIntObjectMap<gnu.trove.map.TIntObjectMap<String>> notes = null;
    private gnu.trove.map.TObjectIntMap<String> valueMap = new gnu.trove.map.hash.TObjectIntHashMap<>();

    public PippinzipState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
        if (game.usesNote()) notes = new gnu.trove.map.hash.TIntObjectHashMap<>();
    }

    public PippinzipState(final PippinzipState other) {
        super(other);
        if (other.notes != null) notes = new gnu.trove.map.hash.TIntObjectHashMap<>(other.notes);
        valueMap = (other.valueMap != null) ? new gnu.trove.map.hash.TObjectIntHashMap<>(other.valueMap) : new gnu.trove.map.hash.TObjectIntHashMap<>();
    }

    @Override public PippinzipState copy() { return new PippinzipState(this); }

    @Override public void resetStateTo(final State other, final Game game) {
        super.resetStateTo(other, game);
        final PippinzipState o = (PippinzipState) other;
        if (o.notes != null) notes = new gnu.trove.map.hash.TIntObjectHashMap<>(o.notes);
        valueMap = (o.valueMap != null) ? new gnu.trove.map.hash.TObjectIntHashMap<>(o.valueMap) : new gnu.trove.map.hash.TObjectIntHashMap<>();
    }

    @Override public void initialise(final Game game) {
        super.initialise(game);
        if (game.usesNote()) notes = new gnu.trove.map.hash.TIntObjectHashMap<>();
        valueMap.clear();
    }

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

    @Override public void setValue(final String key, final int value) { valueMap.put(key, value); }
    @Override public void removeKeyValue(final String key) { valueMap.remove(key); }
    @Override public int getValue(final String key) { return valueMap.containsKey(key) ? valueMap.get(key) : main.Constants.OFF; }
    @Override public gnu.trove.map.TObjectIntMap<String> getValueMap() { return valueMap; }

}
