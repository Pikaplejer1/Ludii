package other.state.t;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for TerhuchuSmall. */
public class TerhuchuSmallState extends State {

    private static final long serialVersionUID = 1L;

    public TerhuchuSmallState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public TerhuchuSmallState(final TerhuchuSmallState other) {
        super(other);
    }

    @Override public TerhuchuSmallState copy() { return new TerhuchuSmallState(this); }

}
