package other.state.h;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Hoyito. */
public class HoyitoState extends State {

    private static final long serialVersionUID = 1L;

    public HoyitoState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public HoyitoState(final HoyitoState other) {
        super(other);
    }

    @Override public HoyitoState copy() { return new HoyitoState(this); }

}
