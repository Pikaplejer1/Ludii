package other.state.y;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Y. */
public class YState extends State {

    private static final long serialVersionUID = 1L;

    public YState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public YState(final YState other) {
        super(other);
    }

    @Override public YState copy() { return new YState(this); }

}
