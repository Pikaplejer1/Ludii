package other.state.k;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Kharebga5x5. */
public class Kharebga5x5State extends State {

    private static final long serialVersionUID = 1L;

    public Kharebga5x5State(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public Kharebga5x5State(final Kharebga5x5State other) {
        super(other);
    }

    @Override public Kharebga5x5State copy() { return new Kharebga5x5State(this); }

}
