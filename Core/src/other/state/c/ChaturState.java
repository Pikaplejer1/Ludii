package other.state.c;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Chatur. */
public class ChaturState extends State {

    private static final long serialVersionUID = 1L;

    public ChaturState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public ChaturState(final ChaturState other) {
        super(other);
    }

    @Override public ChaturState copy() { return new ChaturState(this); }

}
