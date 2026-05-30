package other.state.g;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for GabataOromo. */
public class GabataOromoState extends State {

    private static final long serialVersionUID = 1L;

    private gnu.trove.map.TObjectIntMap<String> valueMap = new gnu.trove.map.hash.TObjectIntHashMap<>();

    public GabataOromoState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public GabataOromoState(final GabataOromoState other) {
        super(other);
        valueMap = (other.valueMap != null) ? new gnu.trove.map.hash.TObjectIntHashMap<>(other.valueMap) : new gnu.trove.map.hash.TObjectIntHashMap<>();
    }

    @Override public GabataOromoState copy() { return new GabataOromoState(this); }

    @Override public void resetStateTo(final State other, final Game game) {
        super.resetStateTo(other, game);
        final GabataOromoState o = (GabataOromoState) other;
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
