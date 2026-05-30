package other.state.d;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Dala. */
public class DalaState extends State {

    private static final long serialVersionUID = 1L;

    public DalaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public DalaState(final DalaState other) {
        super(other);
    }

    @Override public DalaState copy() { return new DalaState(this); }

}
