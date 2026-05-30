package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for SanKwoKI. */
public class SanKwoKIState extends State {

    private static final long serialVersionUID = 1L;

    public SanKwoKIState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SanKwoKIState(final SanKwoKIState other) {
        super(other);
    }

    @Override public SanKwoKIState copy() { return new SanKwoKIState(this); }

}
