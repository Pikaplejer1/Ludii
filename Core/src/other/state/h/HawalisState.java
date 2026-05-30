package other.state.h;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Hawalis. */
public class HawalisState extends State {

    private static final long serialVersionUID = 1L;

    public HawalisState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public HawalisState(final HawalisState other) {
        super(other);
    }

    @Override public HawalisState copy() { return new HawalisState(this); }

}
