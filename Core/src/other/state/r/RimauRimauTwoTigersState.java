package other.state.r;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for RimauRimauTwoTigers. */
public class RimauRimauTwoTigersState extends State {

    private static final long serialVersionUID = 1L;

    public RimauRimauTwoTigersState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public RimauRimauTwoTigersState(final RimauRimauTwoTigersState other) {
        super(other);
    }

    @Override public RimauRimauTwoTigersState copy() { return new RimauRimauTwoTigersState(this); }

}
