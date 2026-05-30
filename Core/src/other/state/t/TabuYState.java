package other.state.t;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for TabuY. */
public class TabuYState extends State {

    private static final long serialVersionUID = 1L;

    public TabuYState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public TabuYState(final TabuYState other) {
        super(other);
    }

    @Override public TabuYState copy() { return new TabuYState(this); }

}
