package other.state.t;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for TicTacToeMisere. */
public class TicTacToeMisereState extends State {

    private static final long serialVersionUID = 1L;

    public TicTacToeMisereState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public TicTacToeMisereState(final TicTacToeMisereState other) {
        super(other);
    }

    @Override public TicTacToeMisereState copy() { return new TicTacToeMisereState(this); }

}
