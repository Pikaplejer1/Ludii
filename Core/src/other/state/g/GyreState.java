package other.state.g;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Gyre. */
public class GyreState extends State {

    private static final long serialVersionUID = 1L;

    public GyreState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public GyreState(final GyreState other) {
        super(other);
    }

    @Override public GyreState copy() { return new GyreState(this); }

}
