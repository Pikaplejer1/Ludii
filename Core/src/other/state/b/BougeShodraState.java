package other.state.b;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for BougeShodra. */
public class BougeShodraState extends State {

    private static final long serialVersionUID = 1L;

    public BougeShodraState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public BougeShodraState(final BougeShodraState other) {
        super(other);
    }

    @Override public BougeShodraState copy() { return new BougeShodraState(this); }

}
