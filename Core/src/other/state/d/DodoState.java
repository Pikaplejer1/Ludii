package other.state.d;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Dodo. */
public class DodoState extends State {

    private static final long serialVersionUID = 1L;

    public DodoState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public DodoState(final DodoState other) {
        super(other);
    }

    @Override public DodoState copy() { return new DodoState(this); }

}
