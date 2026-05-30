package other.state.l;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for LaYagua. */
public class LaYaguaState extends State {

    private static final long serialVersionUID = 1L;

    public LaYaguaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public LaYaguaState(final LaYaguaState other) {
        super(other);
    }

    @Override public LaYaguaState copy() { return new LaYaguaState(this); }

}
