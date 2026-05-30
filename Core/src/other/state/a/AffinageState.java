package other.state.a;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Affinage. */
public class AffinageState extends State {

    private static final long serialVersionUID = 1L;

    public AffinageState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public AffinageState(final AffinageState other) {
        super(other);
    }

    @Override public AffinageState copy() { return new AffinageState(this); }

}
