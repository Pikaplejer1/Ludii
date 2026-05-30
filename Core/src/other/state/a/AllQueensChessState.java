package other.state.a;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for AllQueensChess. */
public class AllQueensChessState extends State {

    private static final long serialVersionUID = 1L;

    public AllQueensChessState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public AllQueensChessState(final AllQueensChessState other) {
        super(other);
    }

    @Override public AllQueensChessState copy() { return new AllQueensChessState(this); }

}
