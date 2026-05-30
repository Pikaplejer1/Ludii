package other.state.i;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for I. */
public class IState extends State {

    private static final long serialVersionUID = 1L;

    public IState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public IState(final IState other) {
        super(other);
    }

    @Override public IState copy() { return new IState(this); }

}
