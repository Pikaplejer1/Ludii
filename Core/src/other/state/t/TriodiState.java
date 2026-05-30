package other.state.t;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Triodi. */
public class TriodiState extends State {

    private static final long serialVersionUID = 1L;

    public TriodiState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public TriodiState(final TriodiState other) {
        super(other);
    }

    @Override public TriodiState copy() { return new TriodiState(this); }

}
