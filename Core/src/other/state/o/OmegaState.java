package other.state.o;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Omega. */
public class OmegaState extends State {

    private static final long serialVersionUID = 1L;

    public OmegaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public OmegaState(final OmegaState other) {
        super(other);
    }

    @Override public OmegaState copy() { return new OmegaState(this); }

}
