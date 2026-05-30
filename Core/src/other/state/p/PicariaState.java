package other.state.p;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Picaria. */
public class PicariaState extends State {

    private static final long serialVersionUID = 1L;

    public PicariaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public PicariaState(final PicariaState other) {
        super(other);
    }

    @Override public PicariaState copy() { return new PicariaState(this); }

}
