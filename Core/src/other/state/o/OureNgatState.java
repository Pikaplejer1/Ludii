package other.state.o;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for OureNgat. */
public class OureNgatState extends State {

    private static final long serialVersionUID = 1L;

    public OureNgatState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public OureNgatState(final OureNgatState other) {
        super(other);
    }

    @Override public OureNgatState copy() { return new OureNgatState(this); }

}
