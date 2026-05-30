package other.state.b;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for BaraGutiBihar. */
public class BaraGutiBiharState extends State {

    private static final long serialVersionUID = 1L;

    public BaraGutiBiharState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public BaraGutiBiharState(final BaraGutiBiharState other) {
        super(other);
    }

    @Override public BaraGutiBiharState copy() { return new BaraGutiBiharState(this); }

}
