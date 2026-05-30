package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Spots. */
public class SpotsState extends State {

    private static final long serialVersionUID = 1L;

    public SpotsState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SpotsState(final SpotsState other) {
        super(other);
    }

    @Override public SpotsState copy() { return new SpotsState(this); }

}
