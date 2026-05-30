package other.state.b;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Bounce. */
public class BounceState extends State {

    private static final long serialVersionUID = 1L;

    public BounceState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public BounceState(final BounceState other) {
        super(other);
    }

    @Override public BounceState copy() { return new BounceState(this); }

}
