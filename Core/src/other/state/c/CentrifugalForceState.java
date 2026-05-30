package other.state.c;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for CentrifugalForce. */
public class CentrifugalForceState extends State {

    private static final long serialVersionUID = 1L;

    public CentrifugalForceState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public CentrifugalForceState(final CentrifugalForceState other) {
        super(other);
    }

    @Override public CentrifugalForceState copy() { return new CentrifugalForceState(this); }

}
