package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Sittuyin. */
public class SittuyinState extends State {

    private static final long serialVersionUID = 1L;

    public SittuyinState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SittuyinState(final SittuyinState other) {
        super(other);
    }

    @Override public SittuyinState copy() { return new SittuyinState(this); }

}
