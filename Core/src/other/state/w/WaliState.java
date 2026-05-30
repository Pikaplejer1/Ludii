package other.state.w;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Wali. */
public class WaliState extends State {

    private static final long serialVersionUID = 1L;

    public WaliState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public WaliState(final WaliState other) {
        super(other);
    }

    @Override public WaliState copy() { return new WaliState(this); }

}
