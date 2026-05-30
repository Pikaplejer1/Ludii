package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Spire. */
public class SpireState extends State {

    private static final long serialVersionUID = 1L;

    public SpireState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SpireState(final SpireState other) {
        super(other);
    }

    @Override public SpireState copy() { return new SpireState(this); }

}
