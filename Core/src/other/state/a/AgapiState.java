package other.state.a;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Agapi. */
public class AgapiState extends State {

    private static final long serialVersionUID = 1L;

    public AgapiState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public AgapiState(final AgapiState other) {
        super(other);
    }

    @Override public AgapiState copy() { return new AgapiState(this); }

}
