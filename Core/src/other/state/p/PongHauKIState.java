package other.state.p;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for PongHauKI. */
public class PongHauKIState extends State {

    private static final long serialVersionUID = 1L;

    public PongHauKIState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public PongHauKIState(final PongHauKIState other) {
        super(other);
    }

    @Override public PongHauKIState copy() { return new PongHauKIState(this); }

}
