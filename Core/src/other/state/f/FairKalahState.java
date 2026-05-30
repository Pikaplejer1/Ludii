package other.state.f;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for FairKalah. */
public class FairKalahState extends State {

    private static final long serialVersionUID = 1L;

    public FairKalahState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public FairKalahState(final FairKalahState other) {
        super(other);
    }

    @Override public FairKalahState copy() { return new FairKalahState(this); }

}
