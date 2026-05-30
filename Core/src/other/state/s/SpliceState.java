package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Splice. */
public class SpliceState extends State {

    private static final long serialVersionUID = 1L;

    public SpliceState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SpliceState(final SpliceState other) {
        super(other);
    }

    @Override public SpliceState copy() { return new SpliceState(this); }

}
