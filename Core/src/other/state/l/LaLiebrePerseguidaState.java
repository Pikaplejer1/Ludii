package other.state.l;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for LaLiebrePerseguida. */
public class LaLiebrePerseguidaState extends State {

    private static final long serialVersionUID = 1L;

    public LaLiebrePerseguidaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public LaLiebrePerseguidaState(final LaLiebrePerseguidaState other) {
        super(other);
    }

    @Override public LaLiebrePerseguidaState copy() { return new LaLiebrePerseguidaState(this); }

}
