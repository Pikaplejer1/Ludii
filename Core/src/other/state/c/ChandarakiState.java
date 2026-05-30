package other.state.c;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Chandaraki. */
public class ChandarakiState extends State {

    private static final long serialVersionUID = 1L;

    public ChandarakiState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public ChandarakiState(final ChandarakiState other) {
        super(other);
    }

    @Override public ChandarakiState copy() { return new ChandarakiState(this); }

}
