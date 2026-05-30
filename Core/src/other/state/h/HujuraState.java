package other.state.h;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Hujura. */
public class HujuraState extends State {

    private static final long serialVersionUID = 1L;

    public HujuraState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public HujuraState(final HujuraState other) {
        super(other);
    }

    @Override public HujuraState copy() { return new HujuraState(this); }

}
