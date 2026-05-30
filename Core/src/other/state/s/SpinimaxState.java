package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Spinimax. */
public class SpinimaxState extends State {

    private static final long serialVersionUID = 1L;

    public SpinimaxState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SpinimaxState(final SpinimaxState other) {
        super(other);
    }

    @Override public SpinimaxState copy() { return new SpinimaxState(this); }

}
