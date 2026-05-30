package other.state.h;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Hoshi. */
public class HoshiState extends State {

    private static final long serialVersionUID = 1L;

    public HoshiState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public HoshiState(final HoshiState other) {
        super(other);
    }

    @Override public HoshiState copy() { return new HoshiState(this); }

}
