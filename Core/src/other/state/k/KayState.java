package other.state.k;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Kay. */
public class KayState extends State {

    private static final long serialVersionUID = 1L;

    public KayState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public KayState(final KayState other) {
        super(other);
    }

    @Override public KayState copy() { return new KayState(this); }

}
