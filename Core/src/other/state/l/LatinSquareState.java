package other.state.l;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for LatinSquare. */
public class LatinSquareState extends State {

    private static final long serialVersionUID = 1L;

    public LatinSquareState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public LatinSquareState(final LatinSquareState other) {
        super(other);
    }

    @Override public LatinSquareState copy() { return new LatinSquareState(this); }

}
