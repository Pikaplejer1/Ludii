package other.state.o;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Onyx. */
public class OnyxState extends State {

    private static final long serialVersionUID = 1L;

    public OnyxState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public OnyxState(final OnyxState other) {
        super(other);
    }

    @Override public OnyxState copy() { return new OnyxState(this); }

}
