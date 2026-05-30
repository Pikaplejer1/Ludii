package other.state.m;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Manu. */
public class ManuState extends State {

    private static final long serialVersionUID = 1L;

    public ManuState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public ManuState(final ManuState other) {
        super(other);
    }

    @Override public ManuState copy() { return new ManuState(this); }

}
