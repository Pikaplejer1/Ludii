package other.state.l;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Lasca. */
public class LascaState extends State {

    private static final long serialVersionUID = 1L;

    public LascaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public LascaState(final LascaState other) {
        super(other);
    }

    @Override public LascaState copy() { return new LascaState(this); }

}
