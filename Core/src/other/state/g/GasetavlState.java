package other.state.g;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Gasetavl. */
public class GasetavlState extends State {

    private static final long serialVersionUID = 1L;

    public GasetavlState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public GasetavlState(final GasetavlState other) {
        super(other);
    }

    @Override public GasetavlState copy() { return new GasetavlState(this); }

}
