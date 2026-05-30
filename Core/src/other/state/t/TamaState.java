package other.state.t;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Tama. */
public class TamaState extends State {

    private static final long serialVersionUID = 1L;

    public TamaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public TamaState(final TamaState other) {
        super(other);
    }

    @Override public TamaState copy() { return new TamaState(this); }

}
