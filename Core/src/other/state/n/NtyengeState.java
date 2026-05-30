package other.state.n;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Ntyenge. */
public class NtyengeState extends State {

    private static final long serialVersionUID = 1L;

    public NtyengeState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public NtyengeState(final NtyengeState other) {
        super(other);
    }

    @Override public NtyengeState copy() { return new NtyengeState(this); }

}
