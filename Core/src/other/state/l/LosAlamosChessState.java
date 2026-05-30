package other.state.l;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for LosAlamosChess. */
public class LosAlamosChessState extends State {

    private static final long serialVersionUID = 1L;

    public LosAlamosChessState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public LosAlamosChessState(final LosAlamosChessState other) {
        super(other);
    }

    @Override public LosAlamosChessState copy() { return new LosAlamosChessState(this); }

}
