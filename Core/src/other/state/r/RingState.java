package other.state.r;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Ring. */
public class RingState extends State {

    private static final long serialVersionUID = 1L;

    public RingState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public RingState(final RingState other) {
        super(other);
    }

    @Override public RingState copy() { return new RingState(this); }

}
