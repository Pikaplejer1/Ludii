package other.state.m;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Manddiare. */
public class ManddiareState extends State {

    private static final long serialVersionUID = 1L;

    public ManddiareState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public ManddiareState(final ManddiareState other) {
        super(other);
    }

    @Override public ManddiareState copy() { return new ManddiareState(this); }

}
