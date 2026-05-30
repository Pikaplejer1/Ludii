package other.state.i;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Insanity. */
public class InsanityState extends State {

    private static final long serialVersionUID = 1L;

    public InsanityState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public InsanityState(final InsanityState other) {
        super(other);
    }

    @Override public InsanityState copy() { return new InsanityState(this); }

}
