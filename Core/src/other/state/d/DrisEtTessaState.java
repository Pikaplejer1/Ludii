package other.state.d;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for DrisEtTessa. */
public class DrisEtTessaState extends State {

    private static final long serialVersionUID = 1L;

    public DrisEtTessaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public DrisEtTessaState(final DrisEtTessaState other) {
        super(other);
    }

    @Override public DrisEtTessaState copy() { return new DrisEtTessaState(this); }

}
