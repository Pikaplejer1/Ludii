package other.state.b;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for BrokenLine. */
public class BrokenLineState extends State {

    private static final long serialVersionUID = 1L;

    public BrokenLineState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public BrokenLineState(final BrokenLineState other) {
        super(other);
    }

    @Override public BrokenLineState copy() { return new BrokenLineState(this); }

}
