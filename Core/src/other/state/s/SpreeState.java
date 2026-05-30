package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Spree. */
public class SpreeState extends State {

    private static final long serialVersionUID = 1L;

    public SpreeState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SpreeState(final SpreeState other) {
        super(other);
    }

    @Override public SpreeState copy() { return new SpreeState(this); }

}
