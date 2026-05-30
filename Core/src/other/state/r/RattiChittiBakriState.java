package other.state.r;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for RattiChittiBakri. */
public class RattiChittiBakriState extends State {

    private static final long serialVersionUID = 1L;

    public RattiChittiBakriState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public RattiChittiBakriState(final RattiChittiBakriState other) {
        super(other);
    }

    @Override public RattiChittiBakriState copy() { return new RattiChittiBakriState(this); }

}
