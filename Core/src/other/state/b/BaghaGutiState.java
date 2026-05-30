package other.state.b;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for BaghaGuti. */
public class BaghaGutiState extends State {

    private static final long serialVersionUID = 1L;

    public BaghaGutiState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public BaghaGutiState(final BaghaGutiState other) {
        super(other);
    }

    @Override public BaghaGutiState copy() { return new BaghaGutiState(this); }

}
