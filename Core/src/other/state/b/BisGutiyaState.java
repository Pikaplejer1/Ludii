package other.state.b;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for BisGutiya. */
public class BisGutiyaState extends State {

    private static final long serialVersionUID = 1L;

    public BisGutiyaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public BisGutiyaState(final BisGutiyaState other) {
        super(other);
    }

    @Override public BisGutiyaState copy() { return new BisGutiyaState(this); }

}
