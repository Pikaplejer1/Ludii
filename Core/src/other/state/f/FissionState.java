package other.state.f;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Fission. */
public class FissionState extends State {

    private static final long serialVersionUID = 1L;

    public FissionState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public FissionState(final FissionState other) {
        super(other);
    }

    @Override public FissionState copy() { return new FissionState(this); }

}
