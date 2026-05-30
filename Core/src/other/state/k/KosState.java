package other.state.k;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Kos. */
public class KosState extends State {

    private static final long serialVersionUID = 1L;

    public KosState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public KosState(final KosState other) {
        super(other);
    }

    @Override public KosState copy() { return new KosState(this); }

}
