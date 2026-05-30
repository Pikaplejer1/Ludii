package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Squava. */
public class SquavaState extends State {

    private static final long serialVersionUID = 1L;

    public SquavaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SquavaState(final SquavaState other) {
        super(other);
    }

    @Override public SquavaState copy() { return new SquavaState(this); }

}
