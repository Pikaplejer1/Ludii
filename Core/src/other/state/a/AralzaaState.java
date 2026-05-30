package other.state.a;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Aralzaa. */
public class AralzaaState extends State {

    private static final long serialVersionUID = 1L;

    public AralzaaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public AralzaaState(final AralzaaState other) {
        super(other);
    }

    @Override public AralzaaState copy() { return new AralzaaState(this); }

}
