package other.state.m;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Mankala. */
public class MankalaState extends State {

    private static final long serialVersionUID = 1L;

    public MankalaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public MankalaState(final MankalaState other) {
        super(other);
    }

    @Override public MankalaState copy() { return new MankalaState(this); }

}
