package other.state.m;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for MagicSquare. */
public class MagicSquareState extends State {

    private static final long serialVersionUID = 1L;

    public MagicSquareState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public MagicSquareState(final MagicSquareState other) {
        super(other);
    }

    @Override public MagicSquareState copy() { return new MagicSquareState(this); }

}
