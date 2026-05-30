package other.state.w;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Wari. */
public class WariState extends State {

    private static final long serialVersionUID = 1L;

    public WariState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public WariState(final WariState other) {
        super(other);
    }

    @Override public WariState copy() { return new WariState(this); }

}
