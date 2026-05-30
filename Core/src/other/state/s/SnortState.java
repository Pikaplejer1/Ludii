package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Snort. */
public class SnortState extends State {

    private static final long serialVersionUID = 1L;

    public SnortState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SnortState(final SnortState other) {
        super(other);
    }

    @Override public SnortState copy() { return new SnortState(this); }

}
