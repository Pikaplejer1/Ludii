package other.state.t;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for TUkTUk. */
public class TUkTUkState extends State {

    private static final long serialVersionUID = 1L;

    public TUkTUkState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public TUkTUkState(final TUkTUkState other) {
        super(other);
    }

    @Override public TUkTUkState copy() { return new TUkTUkState(this); }

}
