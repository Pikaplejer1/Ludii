package other.state.r;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Root. */
public class RootState extends State {

    private static final long serialVersionUID = 1L;

    public RootState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public RootState(final RootState other) {
        super(other);
    }

    @Override public RootState copy() { return new RootState(this); }

}
