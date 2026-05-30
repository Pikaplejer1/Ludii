package other.state.m;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for MaakYek. */
public class MaakYekState extends State {

    private static final long serialVersionUID = 1L;

    public MaakYekState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public MaakYekState(final MaakYekState other) {
        super(other);
    }

    @Override public MaakYekState copy() { return new MaakYekState(this); }

}
