package other.state.p;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for PicariaLarge. */
public class PicariaLargeState extends State {

    private static final long serialVersionUID = 1L;

    public PicariaLargeState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public PicariaLargeState(final PicariaLargeState other) {
        super(other);
    }

    @Override public PicariaLargeState copy() { return new PicariaLargeState(this); }

}
