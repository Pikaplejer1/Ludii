package other.state.g;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for G3DTicTacToe. */
public class G3DTicTacToeState extends State {

    private static final long serialVersionUID = 1L;

    public G3DTicTacToeState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public G3DTicTacToeState(final G3DTicTacToeState other) {
        super(other);
    }

    @Override public G3DTicTacToeState copy() { return new G3DTicTacToeState(this); }

}
