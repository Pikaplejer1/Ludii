package other.state.t;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Trianon. */
public class TrianonState extends State {

    private static final long serialVersionUID = 1L;

    public TrianonState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public TrianonState(final TrianonState other) {
        super(other);
    }

    @Override public TrianonState copy() { return new TrianonState(this); }

}
