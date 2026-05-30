package other.state.l;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Lava. */
public class LavaState extends State {

    private static final long serialVersionUID = 1L;

    public LavaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public LavaState(final LavaState other) {
        super(other);
    }

    @Override public LavaState copy() { return new LavaState(this); }

}
