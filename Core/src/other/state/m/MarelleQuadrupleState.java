package other.state.m;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for MarelleQuadruple. */
public class MarelleQuadrupleState extends State {

    private static final long serialVersionUID = 1L;

    public MarelleQuadrupleState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public MarelleQuadrupleState(final MarelleQuadrupleState other) {
        super(other);
    }

    @Override public MarelleQuadrupleState copy() { return new MarelleQuadrupleState(this); }

}
