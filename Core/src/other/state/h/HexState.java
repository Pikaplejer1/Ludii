package other.state.h;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Hex. */
public class HexState extends State {

    private static final long serialVersionUID = 1L;

    public HexState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public HexState(final HexState other) {
        super(other);
    }

    @Override public HexState copy() { return new HexState(this); }

}
