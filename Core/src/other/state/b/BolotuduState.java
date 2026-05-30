package other.state.b;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Bolotudu. */
public class BolotuduState extends State {

    private static final long serialVersionUID = 1L;

    public BolotuduState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public BolotuduState(final BolotuduState other) {
        super(other);
    }

    @Override public BolotuduState copy() { return new BolotuduState(this); }

}
