package other.state.t;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for TukTak. */
public class TukTakState extends State {

    private static final long serialVersionUID = 1L;

    public TukTakState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public TukTakState(final TukTakState other) {
        super(other);
    }

    @Override public TukTakState copy() { return new TukTakState(this); }

}
