package other.state.c;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Chex. */
public class ChexState extends State {

    private static final long serialVersionUID = 1L;

    public ChexState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public ChexState(final ChexState other) {
        super(other);
    }

    @Override public ChexState copy() { return new ChexState(this); }

}
