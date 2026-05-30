package other.state.o;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Oust. */
public class OustState extends State {

    private static final long serialVersionUID = 1L;

    public OustState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public OustState(final OustState other) {
        super(other);
    }

    @Override public OustState copy() { return new OustState(this); }

}
