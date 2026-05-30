package other.state.t;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for TMbl. */
public class TMblState extends State {

    private static final long serialVersionUID = 1L;

    public TMblState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public TMblState(final TMblState other) {
        super(other);
    }

    @Override public TMblState copy() { return new TMblState(this); }

}
