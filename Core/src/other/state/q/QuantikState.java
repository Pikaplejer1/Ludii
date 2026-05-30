package other.state.q;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Quantik. */
public class QuantikState extends State {

    private static final long serialVersionUID = 1L;

    public QuantikState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public QuantikState(final QuantikState other) {
        super(other);
    }

    @Override public QuantikState copy() { return new QuantikState(this); }

}
