package other.state.f;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Felli. */
public class FelliState extends State {

    private static final long serialVersionUID = 1L;

    public FelliState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public FelliState(final FelliState other) {
        super(other);
    }

    @Override public FelliState copy() { return new FelliState(this); }

}
