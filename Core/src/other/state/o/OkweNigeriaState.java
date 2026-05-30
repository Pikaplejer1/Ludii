package other.state.o;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for OkweNigeria. */
public class OkweNigeriaState extends State {

    private static final long serialVersionUID = 1L;

    private gnu.trove.map.TObjectIntMap<String> valueMap = new gnu.trove.map.hash.TObjectIntHashMap<>();

    public OkweNigeriaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public OkweNigeriaState(final OkweNigeriaState other) {
        super(other);
        valueMap = (other.valueMap != null) ? new gnu.trove.map.hash.TObjectIntHashMap<>(other.valueMap) : new gnu.trove.map.hash.TObjectIntHashMap<>();
    }

    @Override public OkweNigeriaState copy() { return new OkweNigeriaState(this); }

    @Override public void resetStateTo(final State other, final Game game) {
        super.resetStateTo(other, game);
        final OkweNigeriaState o = (OkweNigeriaState) other;
        valueMap = (o.valueMap != null) ? new gnu.trove.map.hash.TObjectIntHashMap<>(o.valueMap) : new gnu.trove.map.hash.TObjectIntHashMap<>();
    }

    @Override public void initialise(final Game game) {
        super.initialise(game);
        valueMap.clear();
    }

    @Override public void setValue(final String key, final int value) { valueMap.put(key, value); }
    @Override public void removeKeyValue(final String key) { valueMap.remove(key); }
    @Override public int getValue(final String key) { return valueMap.containsKey(key) ? valueMap.get(key) : main.Constants.OFF; }
    @Override public gnu.trove.map.TObjectIntMap<String> getValueMap() { return valueMap; }

}
