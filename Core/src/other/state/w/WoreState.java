package other.state.w;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Wore. */
public class WoreState extends State {

    private static final long serialVersionUID = 1L;

    public WoreState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public WoreState(final WoreState other) {
        super(other);
    }

    @Override public WoreState copy() { return new WoreState(this); }

}
