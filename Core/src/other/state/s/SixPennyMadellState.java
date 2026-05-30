package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for SixPennyMadell. */
public class SixPennyMadellState extends State {

    private static final long serialVersionUID = 1L;

    public SixPennyMadellState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SixPennyMadellState(final SixPennyMadellState other) {
        super(other);
    }

    @Override public SixPennyMadellState copy() { return new SixPennyMadellState(this); }

}
