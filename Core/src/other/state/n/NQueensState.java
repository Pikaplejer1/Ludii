package other.state.n;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for NQueens. */
public class NQueensState extends State {

    private static final long serialVersionUID = 1L;

    public NQueensState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public NQueensState(final NQueensState other) {
        super(other);
    }

    @Override public NQueensState copy() { return new NQueensState(this); }

}
