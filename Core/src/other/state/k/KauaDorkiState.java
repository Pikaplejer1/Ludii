package other.state.k;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for KauaDorki. */
public class KauaDorkiState extends State {

    private static final long serialVersionUID = 1L;

    public KauaDorkiState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public KauaDorkiState(final KauaDorkiState other) {
        super(other);
    }

    @Override public KauaDorkiState copy() { return new KauaDorkiState(this); }

}
