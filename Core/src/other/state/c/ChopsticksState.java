package other.state.c;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Chopsticks. */
public class ChopsticksState extends State {

    private static final long serialVersionUID = 1L;

    public ChopsticksState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public ChopsticksState(final ChopsticksState other) {
        super(other);
    }

    @Override public ChopsticksState copy() { return new ChopsticksState(this); }

}
