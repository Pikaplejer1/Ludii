package other.state.f;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Futoshiki. */
public class FutoshikiState extends State {

    private static final long serialVersionUID = 1L;

    public FutoshikiState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public FutoshikiState(final FutoshikiState other) {
        super(other);
    }

    @Override public FutoshikiState copy() { return new FutoshikiState(this); }

}
