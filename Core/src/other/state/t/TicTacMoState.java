package other.state.t;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for TicTacMo. */
public class TicTacMoState extends State {

    private static final long serialVersionUID = 1L;

    public TicTacMoState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public TicTacMoState(final TicTacMoState other) {
        super(other);
    }

    @Override public TicTacMoState copy() { return new TicTacMoState(this); }

}
