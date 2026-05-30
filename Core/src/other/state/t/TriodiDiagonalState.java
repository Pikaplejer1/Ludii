package other.state.t;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for TriodiDiagonal. */
public class TriodiDiagonalState extends State {

    private static final long serialVersionUID = 1L;

    public TriodiDiagonalState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public TriodiDiagonalState(final TriodiDiagonalState other) {
        super(other);
    }

    @Override public TriodiDiagonalState copy() { return new TriodiDiagonalState(this); }

}
