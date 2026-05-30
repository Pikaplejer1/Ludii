package other.state.f;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for FanoronaTelo. */
public class FanoronaTeloState extends State {

    private static final long serialVersionUID = 1L;

    public FanoronaTeloState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public FanoronaTeloState(final FanoronaTeloState other) {
        super(other);
    }

    @Override public FanoronaTeloState copy() { return new FanoronaTeloState(this); }

}
