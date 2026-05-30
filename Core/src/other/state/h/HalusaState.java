package other.state.h;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Halusa. */
public class HalusaState extends State {

    private static final long serialVersionUID = 1L;

    public HalusaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public HalusaState(final HalusaState other) {
        super(other);
    }

    @Override public HalusaState copy() { return new HalusaState(this); }

}
