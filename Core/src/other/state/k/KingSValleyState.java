package other.state.k;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for KingSValley. */
public class KingSValleyState extends State {

    private static final long serialVersionUID = 1L;

    public KingSValleyState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public KingSValleyState(final KingSValleyState other) {
        super(other);
    }

    @Override public KingSValleyState copy() { return new KingSValleyState(this); }

}
