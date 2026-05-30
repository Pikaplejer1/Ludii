package other.state.r;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Ringo. */
public class RingoState extends State {

    private static final long serialVersionUID = 1L;

    public RingoState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public RingoState(final RingoState other) {
        super(other);
    }

    @Override public RingoState copy() { return new RingoState(this); }

}
