package other.state.g;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Gala. */
public class GalaState extends State {

    private static final long serialVersionUID = 1L;

    public GalaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public GalaState(final GalaState other) {
        super(other);
    }

    @Override public GalaState copy() { return new GalaState(this); }

}
