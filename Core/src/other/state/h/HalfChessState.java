package other.state.h;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for HalfChess. */
public class HalfChessState extends State {

    private static final long serialVersionUID = 1L;

    public HalfChessState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public HalfChessState(final HalfChessState other) {
        super(other);
    }

    @Override public HalfChessState copy() { return new HalfChessState(this); }

}
