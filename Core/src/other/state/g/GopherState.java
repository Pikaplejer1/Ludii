package other.state.g;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Gopher. */
public class GopherState extends State {

    private static final long serialVersionUID = 1L;

    public GopherState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public GopherState(final GopherState other) {
        super(other);
    }

    @Override public GopherState copy() { return new GopherState(this); }

}
