package other.state.g;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Gamacha. */
public class GamachaState extends State {

    private static final long serialVersionUID = 1L;

    public GamachaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public GamachaState(final GamachaState other) {
        super(other);
    }

    @Override public GamachaState copy() { return new GamachaState(this); }

}
