package other.state.t;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Tauru. */
public class TauruState extends State {

    private static final long serialVersionUID = 1L;

    public TauruState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public TauruState(final TauruState other) {
        super(other);
    }

    @Override public TauruState copy() { return new TauruState(this); }

}
