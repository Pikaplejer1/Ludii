package other.state.d;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for DuploHex. */
public class DuploHexState extends State {

    private static final long serialVersionUID = 1L;

    public DuploHexState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public DuploHexState(final DuploHexState other) {
        super(other);
    }

    @Override public DuploHexState copy() { return new DuploHexState(this); }

}
