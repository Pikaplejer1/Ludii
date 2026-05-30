package other.state.c;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for ChianaWaBwalo. */
public class ChianaWaBwaloState extends State {

    private static final long serialVersionUID = 1L;

    public ChianaWaBwaloState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public ChianaWaBwaloState(final ChianaWaBwaloState other) {
        super(other);
    }

    @Override public ChianaWaBwaloState copy() { return new ChianaWaBwaloState(this); }

}
