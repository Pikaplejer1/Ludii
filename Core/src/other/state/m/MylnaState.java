package other.state.m;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Mylna. */
public class MylnaState extends State {

    private static final long serialVersionUID = 1L;

    public MylnaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public MylnaState(final MylnaState other) {
        super(other);
    }

    @Override public MylnaState copy() { return new MylnaState(this); }

}
