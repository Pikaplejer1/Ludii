package other.state.m;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Mulabalaba. */
public class MulabalabaState extends State {

    private static final long serialVersionUID = 1L;

    public MulabalabaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public MulabalabaState(final MulabalabaState other) {
        super(other);
    }

    @Override public MulabalabaState copy() { return new MulabalabaState(this); }

}
