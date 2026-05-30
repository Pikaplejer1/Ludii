package other.state.k;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Koro. */
public class KoroState extends State {

    private static final long serialVersionUID = 1L;

    public KoroState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public KoroState(final KoroState other) {
        super(other);
    }

    @Override public KoroState copy() { return new KoroState(this); }

}
