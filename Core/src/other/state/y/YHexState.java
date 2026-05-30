package other.state.y;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for YHex. */
public class YHexState extends State {

    private static final long serialVersionUID = 1L;

    public YHexState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public YHexState(final YHexState other) {
        super(other);
    }

    @Override public YHexState copy() { return new YHexState(this); }

}
