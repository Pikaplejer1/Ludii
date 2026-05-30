package other.state.f;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Flume. */
public class FlumeState extends State {

    private static final long serialVersionUID = 1L;

    public FlumeState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public FlumeState(final FlumeState other) {
        super(other);
    }

    @Override public FlumeState copy() { return new FlumeState(this); }

}
