package other.state.d;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for DrisAtTalata. */
public class DrisAtTalataState extends State {

    private static final long serialVersionUID = 1L;

    public DrisAtTalataState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public DrisAtTalataState(final DrisAtTalataState other) {
        super(other);
    }

    @Override public DrisAtTalataState copy() { return new DrisAtTalataState(this); }

}
