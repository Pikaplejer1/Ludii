package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Sowing. */
public class SowingState extends State {

    private static final long serialVersionUID = 1L;

    public SowingState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SowingState(final SowingState other) {
        super(other);
    }

    @Override public SowingState copy() { return new SowingState(this); }

}
