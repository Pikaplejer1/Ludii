package other.state.k;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Kalah. */
public class KalahState extends State {

    private static final long serialVersionUID = 1L;

    public KalahState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public KalahState(final KalahState other) {
        super(other);
    }

    @Override public KalahState copy() { return new KalahState(this); }

}
