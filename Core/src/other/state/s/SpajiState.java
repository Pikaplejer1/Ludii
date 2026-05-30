package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Spaji. */
public class SpajiState extends State {

    private static final long serialVersionUID = 1L;

    public SpajiState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SpajiState(final SpajiState other) {
        super(other);
    }

    @Override public SpajiState copy() { return new SpajiState(this); }

}
