package other.state.u;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Unfair. */
public class UnfairState extends State {

    private static final long serialVersionUID = 1L;

    public UnfairState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public UnfairState(final UnfairState other) {
        super(other);
    }

    @Override public UnfairState copy() { return new UnfairState(this); }

}
