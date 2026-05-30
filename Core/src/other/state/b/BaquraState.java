package other.state.b;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Baqura. */
public class BaquraState extends State {

    private static final long serialVersionUID = 1L;

    public BaquraState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public BaquraState(final BaquraState other) {
        super(other);
    }

    @Override public BaquraState copy() { return new BaquraState(this); }

}
