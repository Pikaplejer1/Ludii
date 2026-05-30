package other.state.f;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Flowers. */
public class FlowersState extends State {

    private static final long serialVersionUID = 1L;

    public FlowersState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public FlowersState(final FlowersState other) {
        super(other);
    }

    @Override public FlowersState copy() { return new FlowersState(this); }

}
