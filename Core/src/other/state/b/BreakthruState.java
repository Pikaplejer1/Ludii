package other.state.b;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Breakthru. */
public class BreakthruState extends State {

    private static final long serialVersionUID = 1L;

    public BreakthruState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public BreakthruState(final BreakthruState other) {
        super(other);
    }

    @Override public BreakthruState copy() { return new BreakthruState(this); }

}
