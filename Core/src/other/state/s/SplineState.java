package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Spline. */
public class SplineState extends State {

    private static final long serialVersionUID = 1L;

    public SplineState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SplineState(final SplineState other) {
        super(other);
    }

    @Override public SplineState copy() { return new SplineState(this); }

}
