package other.state.f;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Fettas. */
public class FettasState extends State {

    private static final long serialVersionUID = 1L;

    public FettasState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public FettasState(final FettasState other) {
        super(other);
    }

    @Override public FettasState copy() { return new FettasState(this); }

}
