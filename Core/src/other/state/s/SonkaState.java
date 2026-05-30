package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Sonka. */
public class SonkaState extends State {

    private static final long serialVersionUID = 1L;

    public SonkaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SonkaState(final SonkaState other) {
        super(other);
    }

    @Override public SonkaState copy() { return new SonkaState(this); }

}
