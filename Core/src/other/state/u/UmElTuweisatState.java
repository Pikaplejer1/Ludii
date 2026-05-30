package other.state.u;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for UmElTuweisat. */
public class UmElTuweisatState extends State {

    private static final long serialVersionUID = 1L;

    public UmElTuweisatState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public UmElTuweisatState(final UmElTuweisatState other) {
        super(other);
    }

    @Override public UmElTuweisatState copy() { return new UmElTuweisatState(this); }

}
