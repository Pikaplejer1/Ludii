package other.state.g;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for GasetavlGedved. */
public class GasetavlGedvedState extends State {

    private static final long serialVersionUID = 1L;

    public GasetavlGedvedState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public GasetavlGedvedState(final GasetavlGedvedState other) {
        super(other);
    }

    @Override public GasetavlGedvedState copy() { return new GasetavlGedvedState(this); }

}
