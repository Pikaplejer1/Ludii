package other.state.t;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Taktik. */
public class TaktikState extends State {

    private static final long serialVersionUID = 1L;

    public TaktikState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public TaktikState(final TaktikState other) {
        super(other);
    }

    @Override public TaktikState copy() { return new TaktikState(this); }

}
