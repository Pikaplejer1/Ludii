package other.state.d;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Dorvolz. */
public class DorvolzState extends State {

    private static final long serialVersionUID = 1L;

    public DorvolzState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public DorvolzState(final DorvolzState other) {
        super(other);
    }

    @Override public DorvolzState copy() { return new DorvolzState(this); }

}
