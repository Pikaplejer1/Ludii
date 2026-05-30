package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Spava. */
public class SpavaState extends State {

    private static final long serialVersionUID = 1L;

    public SpavaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SpavaState(final SpavaState other) {
        super(other);
    }

    @Override public SpavaState copy() { return new SpavaState(this); }

}
