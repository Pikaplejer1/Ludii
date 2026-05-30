package other.state.i;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Isolation. */
public class IsolationState extends State {

    private static final long serialVersionUID = 1L;

    public IsolationState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public IsolationState(final IsolationState other) {
        super(other);
    }

    @Override public IsolationState copy() { return new IsolationState(this); }

}
