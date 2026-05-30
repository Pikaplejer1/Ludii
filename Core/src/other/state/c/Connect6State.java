package other.state.c;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Connect6. */
public class Connect6State extends State {

    private static final long serialVersionUID = 1L;

    public Connect6State(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public Connect6State(final Connect6State other) {
        super(other);
    }

    @Override public Connect6State copy() { return new Connect6State(this); }

}
