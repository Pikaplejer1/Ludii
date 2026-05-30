package other.state.t;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for TsoroYemutwelve. */
public class TsoroYemutwelveState extends State {

    private static final long serialVersionUID = 1L;

    public TsoroYemutwelveState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public TsoroYemutwelveState(final TsoroYemutwelveState other) {
        super(other);
    }

    @Override public TsoroYemutwelveState copy() { return new TsoroYemutwelveState(this); }

}
