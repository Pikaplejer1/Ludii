package other.state.n;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Nchayo. */
public class NchayoState extends State {

    private static final long serialVersionUID = 1L;

    public NchayoState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public NchayoState(final NchayoState other) {
        super(other);
    }

    @Override public NchayoState copy() { return new NchayoState(this); }

}
