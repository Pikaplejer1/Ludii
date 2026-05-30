package other.state.d;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for DasBohnenspiel. */
public class DasBohnenspielState extends State {

    private static final long serialVersionUID = 1L;

    public DasBohnenspielState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public DasBohnenspielState(final DasBohnenspielState other) {
        super(other);
    }

    @Override public DasBohnenspielState copy() { return new DasBohnenspielState(this); }

}
