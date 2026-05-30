package other.state.f;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Forge. */
public class ForgeState extends State {

    private static final long serialVersionUID = 1L;

    public ForgeState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public ForgeState(final ForgeState other) {
        super(other);
    }

    @Override public ForgeState copy() { return new ForgeState(this); }

}
