package other.state.r;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Radran. */
public class RadranState extends State {

    private static final long serialVersionUID = 1L;

    public RadranState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public RadranState(final RadranState other) {
        super(other);
    }

    @Override public RadranState copy() { return new RadranState(this); }

}
