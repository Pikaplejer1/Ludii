package other.state.f;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for FillAPix. */
public class FillAPixState extends State {

    private static final long serialVersionUID = 1L;

    public FillAPixState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public FillAPixState(final FillAPixState other) {
        super(other);
    }

    @Override public FillAPixState copy() { return new FillAPixState(this); }

}
