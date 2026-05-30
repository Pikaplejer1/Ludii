package other.state.w;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for WureDune. */
public class WureDuneState extends State {

    private static final long serialVersionUID = 1L;

    public WureDuneState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public WureDuneState(final WureDuneState other) {
        super(other);
    }

    @Override public WureDuneState copy() { return new WureDuneState(this); }

}
