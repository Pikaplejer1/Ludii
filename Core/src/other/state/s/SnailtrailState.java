package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Snailtrail. */
public class SnailtrailState extends State {

    private static final long serialVersionUID = 1L;

    public SnailtrailState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SnailtrailState(final SnailtrailState other) {
        super(other);
    }

    @Override public SnailtrailState copy() { return new SnailtrailState(this); }

}
