package other.state.f;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Fivalath. */
public class FivalathState extends State {

    private static final long serialVersionUID = 1L;

    public FivalathState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public FivalathState(final FivalathState other) {
        super(other);
    }

    @Override public FivalathState copy() { return new FivalathState(this); }

}
