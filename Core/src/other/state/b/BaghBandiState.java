package other.state.b;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for BaghBandi. */
public class BaghBandiState extends State {

    private static final long serialVersionUID = 1L;

    public BaghBandiState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public BaghBandiState(final BaghBandiState other) {
        super(other);
    }

    @Override public BaghBandiState copy() { return new BaghBandiState(this); }

}
