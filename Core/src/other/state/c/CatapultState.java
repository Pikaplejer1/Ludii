package other.state.c;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Catapult. */
public class CatapultState extends State {

    private static final long serialVersionUID = 1L;

    public CatapultState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public CatapultState(final CatapultState other) {
        super(other);
    }

    @Override public CatapultState copy() { return new CatapultState(this); }

}
