package other.state.d;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Domineering. */
public class DomineeringState extends State {

    private static final long serialVersionUID = 1L;

    public DomineeringState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public DomineeringState(final DomineeringState other) {
        super(other);
    }

    @Override public DomineeringState copy() { return new DomineeringState(this); }

}
