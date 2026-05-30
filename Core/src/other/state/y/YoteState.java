package other.state.y;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Yote. */
public class YoteState extends State {

    private static final long serialVersionUID = 1L;

    public YoteState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public YoteState(final YoteState other) {
        super(other);
    }

    @Override public YoteState copy() { return new YoteState(this); }

}
