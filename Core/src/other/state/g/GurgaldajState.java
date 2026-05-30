package other.state.g;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Gurgaldaj. */
public class GurgaldajState extends State {

    private static final long serialVersionUID = 1L;

    public GurgaldajState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public GurgaldajState(final GurgaldajState other) {
        super(other);
    }

    @Override public GurgaldajState copy() { return new GurgaldajState(this); }

}
