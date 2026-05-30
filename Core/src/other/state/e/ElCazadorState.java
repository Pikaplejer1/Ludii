package other.state.e;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for ElCazador. */
public class ElCazadorState extends State {

    private static final long serialVersionUID = 1L;

    public ElCazadorState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public ElCazadorState(final ElCazadorState other) {
        super(other);
    }

    @Override public ElCazadorState copy() { return new ElCazadorState(this); }

}
