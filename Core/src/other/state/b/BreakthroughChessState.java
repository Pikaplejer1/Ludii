package other.state.b;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for BreakthroughChess. */
public class BreakthroughChessState extends State {

    private static final long serialVersionUID = 1L;

    public BreakthroughChessState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public BreakthroughChessState(final BreakthroughChessState other) {
        super(other);
    }

    @Override public BreakthroughChessState copy() { return new BreakthroughChessState(this); }

}
