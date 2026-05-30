package other.state.u;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for UpperHand. */
public class UpperHandState extends State {

    private static final long serialVersionUID = 1L;

    public UpperHandState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public UpperHandState(final UpperHandState other) {
        super(other);
    }

    @Override public UpperHandState copy() { return new UpperHandState(this); }

}
