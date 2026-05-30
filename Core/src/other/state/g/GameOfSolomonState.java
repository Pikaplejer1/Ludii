package other.state.g;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for GameOfSolomon. */
public class GameOfSolomonState extends State {

    private static final long serialVersionUID = 1L;

    public GameOfSolomonState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public GameOfSolomonState(final GameOfSolomonState other) {
        super(other);
    }

    @Override public GameOfSolomonState copy() { return new GameOfSolomonState(this); }

}
