package other.state.u;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Un. */
public class UnState extends State {

    private static final long serialVersionUID = 1L;

    public UnState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public UnState(final UnState other) {
        super(other);
    }

    @Override public UnState copy() { return new UnState(this); }

}
