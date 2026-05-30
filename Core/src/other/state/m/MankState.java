package other.state.m;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Mank. */
public class MankState extends State {

    private static final long serialVersionUID = 1L;

    public MankState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public MankState(final MankState other) {
        super(other);
    }

    @Override public MankState copy() { return new MankState(this); }

}
