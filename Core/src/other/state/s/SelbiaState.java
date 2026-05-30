package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Selbia. */
public class SelbiaState extends State {

    private static final long serialVersionUID = 1L;

    public SelbiaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SelbiaState(final SelbiaState other) {
        super(other);
    }

    @Override public SelbiaState copy() { return new SelbiaState(this); }

}
