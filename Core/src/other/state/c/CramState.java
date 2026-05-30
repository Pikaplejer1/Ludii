package other.state.c;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Cram. */
public class CramState extends State {

    private static final long serialVersionUID = 1L;

    public CramState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public CramState(final CramState other) {
        super(other);
    }

    @Override public CramState copy() { return new CramState(this); }

}
