package other.state.w;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Waurie. */
public class WaurieState extends State {

    private static final long serialVersionUID = 1L;

    public WaurieState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public WaurieState(final WaurieState other) {
        super(other);
    }

    @Override public WaurieState copy() { return new WaurieState(this); }

}
