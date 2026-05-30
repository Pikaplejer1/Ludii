package other.state.b;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Bravalath. */
public class BravalathState extends State {

    private static final long serialVersionUID = 1L;

    public BravalathState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public BravalathState(final BravalathState other) {
        super(other);
    }

    @Override public BravalathState copy() { return new BravalathState(this); }

}
