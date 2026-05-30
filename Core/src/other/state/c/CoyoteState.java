package other.state.c;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Coyote. */
public class CoyoteState extends State {

    private static final long serialVersionUID = 1L;

    public CoyoteState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public CoyoteState(final CoyoteState other) {
        super(other);
    }

    @Override public CoyoteState copy() { return new CoyoteState(this); }

}
