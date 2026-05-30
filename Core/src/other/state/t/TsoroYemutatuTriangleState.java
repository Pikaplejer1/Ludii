package other.state.t;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for TsoroYemutatuTriangle. */
public class TsoroYemutatuTriangleState extends State {

    private static final long serialVersionUID = 1L;

    public TsoroYemutatuTriangleState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public TsoroYemutatuTriangleState(final TsoroYemutatuTriangleState other) {
        super(other);
    }

    @Override public TsoroYemutatuTriangleState copy() { return new TsoroYemutatuTriangleState(this); }

}
