package other.state.d;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for DashGuti. */
public class DashGutiState extends State {

    private static final long serialVersionUID = 1L;

    public DashGutiState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public DashGutiState(final DashGutiState other) {
        super(other);
    }

    @Override public DashGutiState copy() { return new DashGutiState(this); }

}
