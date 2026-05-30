package other.state.d;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Dra. */
public class DraState extends State {

    private static final long serialVersionUID = 1L;

    public DraState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public DraState(final DraState other) {
        super(other);
    }

    @Override public DraState copy() { return new DraState(this); }

}
