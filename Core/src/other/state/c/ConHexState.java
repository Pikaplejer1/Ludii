package other.state.c;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for ConHex. */
public class ConHexState extends State {

    private static final long serialVersionUID = 1L;

    public ConHexState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public ConHexState(final ConHexState other) {
        super(other);
    }

    @Override public ConHexState copy() { return new ConHexState(this); }

}
