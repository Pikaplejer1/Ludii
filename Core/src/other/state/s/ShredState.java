package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Shred. */
public class ShredState extends State {

    private static final long serialVersionUID = 1L;

    public ShredState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public ShredState(final ShredState other) {
        super(other);
    }

    @Override public ShredState copy() { return new ShredState(this); }

}
