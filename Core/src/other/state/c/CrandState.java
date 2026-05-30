package other.state.c;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Crand. */
public class CrandState extends State {

    private static final long serialVersionUID = 1L;

    public CrandState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public CrandState(final CrandState other) {
        super(other);
    }

    @Override public CrandState copy() { return new CrandState(this); }

}
