package other.state.n;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Ngolo. */
public class NgoloState extends State {

    private static final long serialVersionUID = 1L;

    public NgoloState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public NgoloState(final NgoloState other) {
        super(other);
    }

    @Override public NgoloState copy() { return new NgoloState(this); }

}
