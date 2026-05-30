package other.state.t;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for TicTacFour. */
public class TicTacFourState extends State {

    private static final long serialVersionUID = 1L;

    public TicTacFourState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public TicTacFourState(final TicTacFourState other) {
        super(other);
    }

    @Override public TicTacFourState copy() { return new TicTacFourState(this); }

}
