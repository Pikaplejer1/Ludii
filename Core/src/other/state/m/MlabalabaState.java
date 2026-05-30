package other.state.m;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Mlabalaba. */
public class MlabalabaState extends State {

    private static final long serialVersionUID = 1L;

    public MlabalabaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public MlabalabaState(final MlabalabaState other) {
        super(other);
    }

    @Override public MlabalabaState copy() { return new MlabalabaState(this); }

}
