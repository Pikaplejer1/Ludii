package other.state.t;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for TowerOfHanoi. */
public class TowerOfHanoiState extends State {

    private static final long serialVersionUID = 1L;

    public TowerOfHanoiState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public TowerOfHanoiState(final TowerOfHanoiState other) {
        super(other);
    }

    @Override public TowerOfHanoiState copy() { return new TowerOfHanoiState(this); }

}
