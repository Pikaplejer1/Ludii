package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Shataranja. */
public class ShataranjaState extends State {

    private static final long serialVersionUID = 1L;

    public ShataranjaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public ShataranjaState(final ShataranjaState other) {
        super(other);
    }

    @Override public ShataranjaState copy() { return new ShataranjaState(this); }

}
