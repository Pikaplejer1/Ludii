package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Signum. */
public class SignumState extends State {

    private static final long serialVersionUID = 1L;

    public SignumState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SignumState(final SignumState other) {
        super(other);
    }

    @Override public SignumState copy() { return new SignumState(this); }

}
