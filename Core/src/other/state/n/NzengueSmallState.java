package other.state.n;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for NzengueSmall. */
public class NzengueSmallState extends State {

    private static final long serialVersionUID = 1L;

    public NzengueSmallState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public NzengueSmallState(final NzengueSmallState other) {
        super(other);
    }

    @Override public NzengueSmallState copy() { return new NzengueSmallState(this); }

}
