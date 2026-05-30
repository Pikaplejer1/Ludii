package other.state.w;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Weave. */
public class WeaveState extends State {

    private static final long serialVersionUID = 1L;

    public WeaveState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public WeaveState(final WeaveState other) {
        super(other);
    }

    @Override public WeaveState copy() { return new WeaveState(this); }

}
