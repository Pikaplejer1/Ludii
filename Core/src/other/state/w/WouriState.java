package other.state.w;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Wouri. */
public class WouriState extends State {

    private static final long serialVersionUID = 1L;

    public WouriState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public WouriState(final WouriState other) {
        super(other);
    }

    @Override public WouriState copy() { return new WouriState(this); }

}
