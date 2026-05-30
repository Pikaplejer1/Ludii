package other.state.n;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for NeinAri. */
public class NeinAriState extends State {

    private static final long serialVersionUID = 1L;

    public NeinAriState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public NeinAriState(final NeinAriState other) {
        super(other);
    }

    @Override public NeinAriState copy() { return new NeinAriState(this); }

}
