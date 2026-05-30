package other.state.x;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Xarajlt. */
public class XarajltState extends State {

    private static final long serialVersionUID = 1L;

    public XarajltState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public XarajltState(final XarajltState other) {
        super(other);
    }

    @Override public XarajltState copy() { return new XarajltState(this); }

}
