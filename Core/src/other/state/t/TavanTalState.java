package other.state.t;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for TavanTal. */
public class TavanTalState extends State {

    private static final long serialVersionUID = 1L;

    public TavanTalState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public TavanTalState(final TavanTalState other) {
        super(other);
    }

    @Override public TavanTalState copy() { return new TavanTalState(this); }

}
