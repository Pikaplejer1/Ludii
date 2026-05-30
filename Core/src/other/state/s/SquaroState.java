package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Squaro. */
public class SquaroState extends State {

    private static final long serialVersionUID = 1L;

    public SquaroState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SquaroState(final SquaroState other) {
        super(other);
    }

    @Override public SquaroState copy() { return new SquaroState(this); }

}
