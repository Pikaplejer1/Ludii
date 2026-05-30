package other.state.e;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Epelle. */
public class EpelleState extends State {

    private static final long serialVersionUID = 1L;

    public EpelleState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public EpelleState(final EpelleState other) {
        super(other);
    }

    @Override public EpelleState copy() { return new EpelleState(this); }

}
