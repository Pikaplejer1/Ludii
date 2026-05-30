package other.state.d;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for DjaraBadakh. */
public class DjaraBadakhState extends State {

    private static final long serialVersionUID = 1L;

    public DjaraBadakhState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public DjaraBadakhState(final DjaraBadakhState other) {
        super(other);
    }

    @Override public DjaraBadakhState copy() { return new DjaraBadakhState(this); }

}
