package other.state.n;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for NgreEE. */
public class NgreEEState extends State {

    private static final long serialVersionUID = 1L;

    public NgreEEState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public NgreEEState(final NgreEEState other) {
        super(other);
    }

    @Override public NgreEEState copy() { return new NgreEEState(this); }

}
