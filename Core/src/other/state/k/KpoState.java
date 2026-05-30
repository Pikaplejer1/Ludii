package other.state.k;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Kpo. */
public class KpoState extends State {

    private static final long serialVersionUID = 1L;

    public KpoState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public KpoState(final KpoState other) {
        super(other);
    }

    @Override public KpoState copy() { return new KpoState(this); }

}
