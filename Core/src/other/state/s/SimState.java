package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Sim. */
public class SimState extends State {

    private static final long serialVersionUID = 1L;

    public SimState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SimState(final SimState other) {
        super(other);
    }

    @Override public SimState copy() { return new SimState(this); }

}
