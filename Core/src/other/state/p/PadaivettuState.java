package other.state.p;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Padaivettu. */
public class PadaivettuState extends State {

    private static final long serialVersionUID = 1L;

    public PadaivettuState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public PadaivettuState(final PadaivettuState other) {
        super(other);
    }

    @Override public PadaivettuState copy() { return new PadaivettuState(this); }

}
