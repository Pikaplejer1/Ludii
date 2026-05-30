package other.state.r;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Roots. */
public class RootsState extends State {

    private static final long serialVersionUID = 1L;

    public RootsState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public RootsState(final RootsState other) {
        super(other);
    }

    @Override public RootsState copy() { return new RootsState(this); }

}
