package other.state.m;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for MakeMuster. */
public class MakeMusterState extends State {

    private static final long serialVersionUID = 1L;

    public MakeMusterState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public MakeMusterState(final MakeMusterState other) {
        super(other);
    }

    @Override public MakeMusterState copy() { return new MakeMusterState(this); }

}
