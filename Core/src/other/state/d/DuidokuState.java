package other.state.d;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Duidoku. */
public class DuidokuState extends State {

    private static final long serialVersionUID = 1L;

    public DuidokuState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public DuidokuState(final DuidokuState other) {
        super(other);
    }

    @Override public DuidokuState copy() { return new DuidokuState(this); }

}
