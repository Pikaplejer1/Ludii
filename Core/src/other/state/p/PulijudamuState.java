package other.state.p;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Pulijudamu. */
public class PulijudamuState extends State {

    private static final long serialVersionUID = 1L;

    public PulijudamuState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public PulijudamuState(final PulijudamuState other) {
        super(other);
    }

    @Override public PulijudamuState copy() { return new PulijudamuState(this); }

}
