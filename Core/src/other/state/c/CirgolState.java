package other.state.c;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Cirgol. */
public class CirgolState extends State {

    private static final long serialVersionUID = 1L;

    public CirgolState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public CirgolState(final CirgolState other) {
        super(other);
    }

    @Override public CirgolState copy() { return new CirgolState(this); }

}
