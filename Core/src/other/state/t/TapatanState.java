package other.state.t;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Tapatan. */
public class TapatanState extends State {

    private static final long serialVersionUID = 1L;

    public TapatanState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public TapatanState(final TapatanState other) {
        super(other);
    }

    @Override public TapatanState copy() { return new TapatanState(this); }

}
