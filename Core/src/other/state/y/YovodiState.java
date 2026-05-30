package other.state.y;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Yovodi. */
public class YovodiState extends State {

    private static final long serialVersionUID = 1L;

    public YovodiState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public YovodiState(final YovodiState other) {
        super(other);
    }

    @Override public YovodiState copy() { return new YovodiState(this); }

}
