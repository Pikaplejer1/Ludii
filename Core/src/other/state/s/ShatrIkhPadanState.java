package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for ShatrIkhPadan. */
public class ShatrIkhPadanState extends State {

    private static final long serialVersionUID = 1L;

    public ShatrIkhPadanState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public ShatrIkhPadanState(final ShatrIkhPadanState other) {
        super(other);
    }

    @Override public ShatrIkhPadanState copy() { return new ShatrIkhPadanState(this); }

}
