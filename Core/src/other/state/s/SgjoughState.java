package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Sgjough. */
public class SgjoughState extends State {

    private static final long serialVersionUID = 1L;

    public SgjoughState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SgjoughState(final SgjoughState other) {
        super(other);
    }

    @Override public SgjoughState copy() { return new SgjoughState(this); }

}
