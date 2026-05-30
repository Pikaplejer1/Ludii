package other.state.t;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for TantFant. */
public class TantFantState extends State {

    private static final long serialVersionUID = 1L;

    public TantFantState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public TantFantState(final TantFantState other) {
        super(other);
    }

    @Override public TantFantState copy() { return new TantFantState(this); }

}
