package other.state.b;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Bajr. */
public class BajrState extends State {

    private static final long serialVersionUID = 1L;

    public BajrState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public BajrState(final BajrState other) {
        super(other);
    }

    @Override public BajrState copy() { return new BajrState(this); }

}
