package other.state.b;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Bashni. */
public class BashniState extends State {

    private static final long serialVersionUID = 1L;

    public BashniState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public BashniState(final BashniState other) {
        super(other);
    }

    @Override public BashniState copy() { return new BashniState(this); }

}
