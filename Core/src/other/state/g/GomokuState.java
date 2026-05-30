package other.state.g;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Gomoku. */
public class GomokuState extends State {

    private static final long serialVersionUID = 1L;

    public GomokuState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public GomokuState(final GomokuState other) {
        super(other);
    }

    @Override public GomokuState copy() { return new GomokuState(this); }

}
