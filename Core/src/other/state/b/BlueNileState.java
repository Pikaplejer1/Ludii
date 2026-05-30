package other.state.b;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for BlueNile. */
public class BlueNileState extends State {

    private static final long serialVersionUID = 1L;

    public BlueNileState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public BlueNileState(final BlueNileState other) {
        super(other);
    }

    @Override public BlueNileState copy() { return new BlueNileState(this); }

}
