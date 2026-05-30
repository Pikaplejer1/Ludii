package other.state.p;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for PegSolitaire. */
public class PegSolitaireState extends State {

    private static final long serialVersionUID = 1L;

    public PegSolitaireState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public PegSolitaireState(final PegSolitaireState other) {
        super(other);
    }

    @Override public PegSolitaireState copy() { return new PegSolitaireState(this); }

}
