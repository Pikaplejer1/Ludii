package other.state.b;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Barca. */
public class BarcaState extends State {

    private static final long serialVersionUID = 1L;

    public BarcaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public BarcaState(final BarcaState other) {
        super(other);
    }

    @Override public BarcaState copy() { return new BarcaState(this); }

}
