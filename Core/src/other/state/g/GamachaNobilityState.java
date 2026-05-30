package other.state.g;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for GamachaNobility. */
public class GamachaNobilityState extends State {

    private static final long serialVersionUID = 1L;

    public GamachaNobilityState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public GamachaNobilityState(final GamachaNobilityState other) {
        super(other);
    }

    @Override public GamachaNobilityState copy() { return new GamachaNobilityState(this); }

}
