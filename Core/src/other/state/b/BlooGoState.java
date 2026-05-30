package other.state.b;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for BlooGo. */
public class BlooGoState extends State {

    private static final long serialVersionUID = 1L;

    public BlooGoState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public BlooGoState(final BlooGoState other) {
        super(other);
    }

    @Override public BlooGoState copy() { return new BlooGoState(this); }

}
