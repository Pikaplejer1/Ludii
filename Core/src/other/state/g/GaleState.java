package other.state.g;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Gale. */
public class GaleState extends State {

    private static final long serialVersionUID = 1L;

    public GaleState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public GaleState(final GaleState other) {
        super(other);
    }

    @Override public GaleState copy() { return new GaleState(this); }

}
