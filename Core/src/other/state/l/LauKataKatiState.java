package other.state.l;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for LauKataKati. */
public class LauKataKatiState extends State {

    private static final long serialVersionUID = 1L;

    public LauKataKatiState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public LauKataKatiState(final LauKataKatiState other) {
        super(other);
    }

    @Override public LauKataKatiState copy() { return new LauKataKatiState(this); }

}
