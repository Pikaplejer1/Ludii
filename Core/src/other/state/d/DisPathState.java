package other.state.d;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for DisPath. */
public class DisPathState extends State {

    private static final long serialVersionUID = 1L;

    public DisPathState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public DisPathState(final DisPathState other) {
        super(other);
    }

    @Override public DisPathState copy() { return new DisPathState(this); }

}
