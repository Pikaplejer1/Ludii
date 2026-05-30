package other.state.d;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Doov. */
public class DoovState extends State {

    private static final long serialVersionUID = 1L;

    public DoovState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public DoovState(final DoovState other) {
        super(other);
    }

    @Override public DoovState copy() { return new DoovState(this); }

}
