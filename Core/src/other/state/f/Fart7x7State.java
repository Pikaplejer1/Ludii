package other.state.f;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Fart7x7. */
public class Fart7x7State extends State {

    private static final long serialVersionUID = 1L;

    public Fart7x7State(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public Fart7x7State(final Fart7x7State other) {
        super(other);
    }

    @Override public Fart7x7State copy() { return new Fart7x7State(this); }

}
