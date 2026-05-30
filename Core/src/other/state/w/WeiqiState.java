package other.state.w;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Weiqi. */
public class WeiqiState extends State {

    private static final long serialVersionUID = 1L;

    public WeiqiState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public WeiqiState(final WeiqiState other) {
        super(other);
    }

    @Override public WeiqiState copy() { return new WeiqiState(this); }

}
