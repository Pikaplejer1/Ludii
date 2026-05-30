package other.state.t;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for TulePaid. */
public class TulePaidState extends State {

    private static final long serialVersionUID = 1L;

    public TulePaidState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public TulePaidState(final TulePaidState other) {
        super(other);
    }

    @Override public TulePaidState copy() { return new TulePaidState(this); }

}
