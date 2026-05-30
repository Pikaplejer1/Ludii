package other.state.t;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Trax. */
public class TraxState extends State {

    private static final long serialVersionUID = 1L;

    public TraxState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public TraxState(final TraxState other) {
        super(other);
    }

    @Override public TraxState copy() { return new TraxState(this); }

}
