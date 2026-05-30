package other.state.x;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for XananZirge. */
public class XananZirgeState extends State {

    private static final long serialVersionUID = 1L;

    public XananZirgeState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public XananZirgeState(final XananZirgeState other) {
        super(other);
    }

    @Override public XananZirgeState copy() { return new XananZirgeState(this); }

}
