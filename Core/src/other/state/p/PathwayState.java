package other.state.p;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Pathway. */
public class PathwayState extends State {

    private static final long serialVersionUID = 1L;

    public PathwayState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public PathwayState(final PathwayState other) {
        super(other);
    }

    @Override public PathwayState copy() { return new PathwayState(this); }

}
