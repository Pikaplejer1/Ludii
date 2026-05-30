package other.state.b;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Barbarian. */
public class BarbarianState extends State {

    private static final long serialVersionUID = 1L;

    public BarbarianState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public BarbarianState(final BarbarianState other) {
        super(other);
    }

    @Override public BarbarianState copy() { return new BarbarianState(this); }

}
