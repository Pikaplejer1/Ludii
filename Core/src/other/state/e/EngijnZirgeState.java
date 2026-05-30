package other.state.e;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for EngijnZirge. */
public class EngijnZirgeState extends State {

    private static final long serialVersionUID = 1L;

    public EngijnZirgeState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public EngijnZirgeState(final EngijnZirgeState other) {
        super(other);
    }

    @Override public EngijnZirgeState copy() { return new EngijnZirgeState(this); }

}
