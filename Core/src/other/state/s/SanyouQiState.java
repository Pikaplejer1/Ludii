package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for SanyouQi. */
public class SanyouQiState extends State {

    private static final long serialVersionUID = 1L;

    public SanyouQiState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SanyouQiState(final SanyouQiState other) {
        super(other);
    }

    @Override public SanyouQiState copy() { return new SanyouQiState(this); }

}
