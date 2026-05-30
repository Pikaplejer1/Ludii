package other.state.r;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Rolit. */
public class RolitState extends State {

    private static final long serialVersionUID = 1L;

    public RolitState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public RolitState(final RolitState other) {
        super(other);
    }

    @Override public RolitState copy() { return new RolitState(this); }

}
