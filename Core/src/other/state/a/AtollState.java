package other.state.a;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Atoll. */
public class AtollState extends State {

    private static final long serialVersionUID = 1L;

    public AtollState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public AtollState(final AtollState other) {
        super(other);
    }

    @Override public AtollState copy() { return new AtollState(this); }

}
