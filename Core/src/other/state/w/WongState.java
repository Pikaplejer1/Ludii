package other.state.w;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Wong. */
public class WongState extends State {

    private static final long serialVersionUID = 1L;

    public WongState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public WongState(final WongState other) {
        super(other);
    }

    @Override public WongState copy() { return new WongState(this); }

}
