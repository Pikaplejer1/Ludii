package other.state.m;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Mity. */
public class MityState extends State {

    private static final long serialVersionUID = 1L;

    public MityState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public MityState(final MityState other) {
        super(other);
    }

    @Override public MityState copy() { return new MityState(this); }

}
