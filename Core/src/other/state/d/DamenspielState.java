package other.state.d;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Damenspiel. */
public class DamenspielState extends State {

    private static final long serialVersionUID = 1L;

    public DamenspielState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public DamenspielState(final DamenspielState other) {
        super(other);
    }

    @Override public DamenspielState copy() { return new DamenspielState(this); }

}
