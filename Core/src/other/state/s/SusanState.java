package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Susan. */
public class SusanState extends State {

    private static final long serialVersionUID = 1L;

    public SusanState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SusanState(final SusanState other) {
        super(other);
    }

    @Override public SusanState copy() { return new SusanState(this); }

}
