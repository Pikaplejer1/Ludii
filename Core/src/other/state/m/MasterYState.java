package other.state.m;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for MasterY. */
public class MasterYState extends State {

    private static final long serialVersionUID = 1L;

    public MasterYState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public MasterYState(final MasterYState other) {
        super(other);
    }

    @Override public MasterYState copy() { return new MasterYState(this); }

}
