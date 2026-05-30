package other.state.c;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for CentripetalForce. */
public class CentripetalForceState extends State {

    private static final long serialVersionUID = 1L;

    public CentripetalForceState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public CentripetalForceState(final CentripetalForceState other) {
        super(other);
    }

    @Override public CentripetalForceState copy() { return new CentripetalForceState(this); }

}
