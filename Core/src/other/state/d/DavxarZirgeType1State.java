package other.state.d;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for DavxarZirgeType1. */
public class DavxarZirgeType1State extends State {

    private static final long serialVersionUID = 1L;

    public DavxarZirgeType1State(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public DavxarZirgeType1State(final DavxarZirgeType1State other) {
        super(other);
    }

    @Override public DavxarZirgeType1State copy() { return new DavxarZirgeType1State(this); }

}
