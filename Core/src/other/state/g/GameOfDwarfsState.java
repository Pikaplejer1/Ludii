package other.state.g;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for GameOfDwarfs. */
public class GameOfDwarfsState extends State {

    private static final long serialVersionUID = 1L;

    public GameOfDwarfsState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public GameOfDwarfsState(final GameOfDwarfsState other) {
        super(other);
    }

    @Override public GameOfDwarfsState copy() { return new GameOfDwarfsState(this); }

}
