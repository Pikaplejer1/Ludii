package other.state.d;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Dabuda. */
public class DabudaState extends State {

    private static final long serialVersionUID = 1L;

    public DabudaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public DabudaState(final DabudaState other) {
        super(other);
    }

    @Override public DabudaState copy() { return new DabudaState(this); }

}
