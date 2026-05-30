package other.state.k;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Kharebga7x7. */
public class Kharebga7x7State extends State {

    private static final long serialVersionUID = 1L;

    public Kharebga7x7State(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public Kharebga7x7State(final Kharebga7x7State other) {
        super(other);
    }

    @Override public Kharebga7x7State copy() { return new Kharebga7x7State(this); }

}
