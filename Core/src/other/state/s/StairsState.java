package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Stairs. */
public class StairsState extends State {

    private static final long serialVersionUID = 1L;

    public StairsState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public StairsState(final StairsState other) {
        super(other);
    }

    @Override public StairsState copy() { return new StairsState(this); }

}
