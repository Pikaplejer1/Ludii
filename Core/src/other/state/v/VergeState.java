package other.state.v;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Verge. */
public class VergeState extends State {

    private static final long serialVersionUID = 1L;

    public VergeState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public VergeState(final VergeState other) {
        super(other);
    }

    @Override public VergeState copy() { return new VergeState(this); }

}
