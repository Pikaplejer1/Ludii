package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Shatren. */
public class ShatrenState extends State {

    private static final long serialVersionUID = 1L;

    public ShatrenState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public ShatrenState(final ShatrenState other) {
        super(other);
    }

    @Override public ShatrenState copy() { return new ShatrenState(this); }

}
