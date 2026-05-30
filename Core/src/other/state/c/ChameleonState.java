package other.state.c;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Chameleon. */
public class ChameleonState extends State {

    private static final long serialVersionUID = 1L;

    public ChameleonState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public ChameleonState(final ChameleonState other) {
        super(other);
    }

    @Override public ChameleonState copy() { return new ChameleonState(this); }

}
