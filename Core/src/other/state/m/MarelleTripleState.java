package other.state.m;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for MarelleTriple. */
public class MarelleTripleState extends State {

    private static final long serialVersionUID = 1L;

    public MarelleTripleState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public MarelleTripleState(final MarelleTripleState other) {
        super(other);
    }

    @Override public MarelleTripleState copy() { return new MarelleTripleState(this); }

}
