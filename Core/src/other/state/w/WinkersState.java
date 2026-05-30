package other.state.w;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Winkers. */
public class WinkersState extends State {

    private static final long serialVersionUID = 1L;

    public WinkersState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public WinkersState(final WinkersState other) {
        super(other);
    }

    @Override public WinkersState copy() { return new WinkersState(this); }

}
