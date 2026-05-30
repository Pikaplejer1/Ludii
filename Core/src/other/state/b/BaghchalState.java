package other.state.b;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Baghchal. */
public class BaghchalState extends State {

    private static final long serialVersionUID = 1L;

    public BaghchalState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public BaghchalState(final BaghchalState other) {
        super(other);
    }

    @Override public BaghchalState copy() { return new BaghchalState(this); }

}
