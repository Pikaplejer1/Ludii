package other.state.t;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Terhuchu. */
public class TerhuchuState extends State {

    private static final long serialVersionUID = 1L;

    public TerhuchuState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public TerhuchuState(final TerhuchuState other) {
        super(other);
    }

    @Override public TerhuchuState copy() { return new TerhuchuState(this); }

}
