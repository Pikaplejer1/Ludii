package other.state.e;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for ElZorro. */
public class ElZorroState extends State {

    private static final long serialVersionUID = 1L;

    public ElZorroState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public ElZorroState(final ElZorroState other) {
        super(other);
    }

    @Override public ElZorroState copy() { return new ElZorroState(this); }

}
