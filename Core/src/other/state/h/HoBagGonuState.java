package other.state.h;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for HoBagGonu. */
public class HoBagGonuState extends State {

    private static final long serialVersionUID = 1L;

    public HoBagGonuState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public HoBagGonuState(final HoBagGonuState other) {
        super(other);
    }

    @Override public HoBagGonuState copy() { return new HoBagGonuState(this); }

}
