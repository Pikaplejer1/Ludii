package other.state.m;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Maze. */
public class MazeState extends State {

    private static final long serialVersionUID = 1L;

    public MazeState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public MazeState(final MazeState other) {
        super(other);
    }

    @Override public MazeState copy() { return new MazeState(this); }

}
