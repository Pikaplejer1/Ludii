package other.state.u;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for UltimateTicTacToe. */
public class UltimateTicTacToeState extends State {

    private static final long serialVersionUID = 1L;

    public UltimateTicTacToeState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public UltimateTicTacToeState(final UltimateTicTacToeState other) {
        super(other);
    }

    @Override public UltimateTicTacToeState copy() { return new UltimateTicTacToeState(this); }

}
