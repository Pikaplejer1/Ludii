package other.state.m;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for MuTorere. */
public class MuTorereState extends State {

    private static final long serialVersionUID = 1L;

    public MuTorereState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public MuTorereState(final MuTorereState other) {
        super(other);
    }

    @Override public MuTorereState copy() { return new MuTorereState(this); }

}
