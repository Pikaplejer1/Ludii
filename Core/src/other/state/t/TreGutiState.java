package other.state.t;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for TreGuti. */
public class TreGutiState extends State {

    private static final long serialVersionUID = 1L;

    public TreGutiState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public TreGutiState(final TreGutiState other) {
        super(other);
    }

    @Override public TreGutiState copy() { return new TreGutiState(this); }

}
