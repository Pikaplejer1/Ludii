package other.state.t;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for TapUrdy. */
public class TapUrdyState extends State {

    private static final long serialVersionUID = 1L;

    public TapUrdyState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public TapUrdyState(final TapUrdyState other) {
        super(other);
    }

    @Override public TapUrdyState copy() { return new TapUrdyState(this); }

}
