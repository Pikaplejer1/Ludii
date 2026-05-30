package other.state.h;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Hermit. */
public class HermitState extends State {

    private static final long serialVersionUID = 1L;

    public HermitState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public HermitState(final HermitState other) {
        super(other);
    }

    @Override public HermitState copy() { return new HermitState(this); }

}
