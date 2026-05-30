package other.state.n;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for NoGo. */
public class NoGoState extends State {

    private static final long serialVersionUID = 1L;

    public NoGoState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public NoGoState(final NoGoState other) {
        super(other);
    }

    @Override public NoGoState copy() { return new NoGoState(this); }

}
