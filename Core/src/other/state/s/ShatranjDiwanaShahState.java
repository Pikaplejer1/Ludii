package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for ShatranjDiwanaShah. */
public class ShatranjDiwanaShahState extends State {

    private static final long serialVersionUID = 1L;

    public ShatranjDiwanaShahState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public ShatranjDiwanaShahState(final ShatranjDiwanaShahState other) {
        super(other);
    }

    @Override public ShatranjDiwanaShahState copy() { return new ShatranjDiwanaShahState(this); }

}
