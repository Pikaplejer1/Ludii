package other.state.t;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for TsoroReenteredCaptures. */
public class TsoroReenteredCapturesState extends State {

    private static final long serialVersionUID = 1L;

    public TsoroReenteredCapturesState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public TsoroReenteredCapturesState(final TsoroReenteredCapturesState other) {
        super(other);
    }

    @Override public TsoroReenteredCapturesState copy() { return new TsoroReenteredCapturesState(this); }

}
