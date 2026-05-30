package other.state.b;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Bamboo. */
public class BambooState extends State {

    private static final long serialVersionUID = 1L;

    public BambooState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public BambooState(final BambooState other) {
        super(other);
    }

    @Override public BambooState copy() { return new BambooState(this); }

}
