package other.state.f;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Fart5x5. */
public class Fart5x5State extends State {

    private static final long serialVersionUID = 1L;

    public Fart5x5State(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public Fart5x5State(final Fart5x5State other) {
        super(other);
    }

    @Override public Fart5x5State copy() { return new Fart5x5State(this); }

}
