package other.state.t;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Takuzu. */
public class TakuzuState extends State {

    private static final long serialVersionUID = 1L;

    public TakuzuState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public TakuzuState(final TakuzuState other) {
        super(other);
    }

    @Override public TakuzuState copy() { return new TakuzuState(this); }

}
