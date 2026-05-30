package other.state.c;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Crossway. */
public class CrosswayState extends State {

    private static final long serialVersionUID = 1L;

    public CrosswayState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public CrosswayState(final CrosswayState other) {
        super(other);
    }

    @Override public CrosswayState copy() { return new CrosswayState(this); }

}
