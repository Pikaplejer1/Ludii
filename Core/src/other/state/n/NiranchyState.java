package other.state.n;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Niranchy. */
public class NiranchyState extends State {

    private static final long serialVersionUID = 1L;

    public NiranchyState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public NiranchyState(final NiranchyState other) {
        super(other);
    }

    @Override public NiranchyState copy() { return new NiranchyState(this); }

}
