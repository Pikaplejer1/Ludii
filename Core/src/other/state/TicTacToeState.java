package other.state;

import game.Game;
import game.Game.StateConstructorLock;

/** Auto-generated State subclass for TicTacToe. */
public class TicTacToeState extends State {

    private static final long serialVersionUID = 1L;

    public TicTacToeState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public TicTacToeState(final TicTacToeState other) {
        super(other);
    }

    @Override public TicTacToeState copy() { return new TicTacToeState(this); }

}
