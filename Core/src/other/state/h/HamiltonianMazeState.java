package other.state.h;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for HamiltonianMaze. */
public class HamiltonianMazeState extends State {

    private static final long serialVersionUID = 1L;

    public HamiltonianMazeState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public HamiltonianMazeState(final HamiltonianMazeState other) {
        super(other);
    }

    @Override public HamiltonianMazeState copy() { return new HamiltonianMazeState(this); }

}
