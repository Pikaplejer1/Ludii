package other.state.r;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Refskak. */
public class RefskakState extends State {

    private static final long serialVersionUID = 1L;

    public RefskakState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public RefskakState(final RefskakState other) {
        super(other);
    }

    @Override public RefskakState copy() { return new RefskakState(this); }

}
