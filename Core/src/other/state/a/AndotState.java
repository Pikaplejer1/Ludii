package other.state.a;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Andot. */
public class AndotState extends State {

    private static final long serialVersionUID = 1L;

    public AndotState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public AndotState(final AndotState other) {
        super(other);
    }

    @Override public AndotState copy() { return new AndotState(this); }

}
