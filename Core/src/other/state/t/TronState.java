package other.state.t;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Tron. */
public class TronState extends State {

    private static final long serialVersionUID = 1L;

    public TronState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public TronState(final TronState other) {
        super(other);
    }

    @Override public TronState copy() { return new TronState(this); }

}
