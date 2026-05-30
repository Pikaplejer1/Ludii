package other.state.k;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Konane. */
public class KonaneState extends State {

    private static final long serialVersionUID = 1L;

    public KonaneState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public KonaneState(final KonaneState other) {
        super(other);
    }

    @Override public KonaneState copy() { return new KonaneState(this); }

}
