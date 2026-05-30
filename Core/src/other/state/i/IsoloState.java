package other.state.i;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Isolo. */
public class IsoloState extends State {

    private static final long serialVersionUID = 1L;

    public IsoloState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public IsoloState(final IsoloState other) {
        super(other);
    }

    @Override public IsoloState copy() { return new IsoloState(this); }

}
