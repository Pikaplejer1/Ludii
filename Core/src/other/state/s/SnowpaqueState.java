package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Snowpaque. */
public class SnowpaqueState extends State {

    private static final long serialVersionUID = 1L;

    public SnowpaqueState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SnowpaqueState(final SnowpaqueState other) {
        super(other);
    }

    @Override public SnowpaqueState copy() { return new SnowpaqueState(this); }

}
