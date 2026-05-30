package other.state.i;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Intotoi. */
public class IntotoiState extends State {

    private static final long serialVersionUID = 1L;

    public IntotoiState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public IntotoiState(final IntotoiState other) {
        super(other);
    }

    @Override public IntotoiState copy() { return new IntotoiState(this); }

}
