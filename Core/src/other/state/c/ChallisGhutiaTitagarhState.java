package other.state.c;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for ChallisGhutiaTitagarh. */
public class ChallisGhutiaTitagarhState extends State {

    private static final long serialVersionUID = 1L;

    public ChallisGhutiaTitagarhState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public ChallisGhutiaTitagarhState(final ChallisGhutiaTitagarhState other) {
        super(other);
    }

    @Override public ChallisGhutiaTitagarhState copy() { return new ChallisGhutiaTitagarhState(this); }

}
