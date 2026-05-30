package other.state.g;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Gonnect. */
public class GonnectState extends State {

    private static final long serialVersionUID = 1L;

    public GonnectState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public GonnectState(final GonnectState other) {
        super(other);
    }

    @Override public GonnectState copy() { return new GonnectState(this); }

}
