package other.state.b;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Bipod. */
public class BipodState extends State {

    private static final long serialVersionUID = 1L;

    public BipodState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public BipodState(final BipodState other) {
        super(other);
    }

    @Override public BipodState copy() { return new BipodState(this); }

}
