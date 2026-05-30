package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Spaiji. */
public class SpaijiState extends State {

    private static final long serialVersionUID = 1L;

    public SpaijiState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SpaijiState(final SpaijiState other) {
        super(other);
    }

    @Override public SpaijiState copy() { return new SpaijiState(this); }

}
