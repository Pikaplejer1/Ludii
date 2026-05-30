package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Saxun. */
public class SaxunState extends State {

    private static final long serialVersionUID = 1L;

    public SaxunState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SaxunState(final SaxunState other) {
        super(other);
    }

    @Override public SaxunState copy() { return new SaxunState(this); }

}
