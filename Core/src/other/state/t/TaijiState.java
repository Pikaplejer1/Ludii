package other.state.t;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Taiji. */
public class TaijiState extends State {

    private static final long serialVersionUID = 1L;

    public TaijiState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public TaijiState(final TaijiState other) {
        super(other);
    }

    @Override public TaijiState copy() { return new TaijiState(this); }

}
