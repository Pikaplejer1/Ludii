package other.state.h;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Haretavl. */
public class HaretavlState extends State {

    private static final long serialVersionUID = 1L;

    public HaretavlState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public HaretavlState(final HaretavlState other) {
        super(other);
    }

    @Override public HaretavlState copy() { return new HaretavlState(this); }

}
