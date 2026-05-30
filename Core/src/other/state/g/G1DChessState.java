package other.state.g;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for G1DChess. */
public class G1DChessState extends State {

    private static final long serialVersionUID = 1L;

    public G1DChessState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public G1DChessState(final G1DChessState other) {
        super(other);
    }

    @Override public G1DChessState copy() { return new G1DChessState(this); }

}
