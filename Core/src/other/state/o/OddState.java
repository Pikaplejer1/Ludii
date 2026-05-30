package other.state.o;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Odd. */
public class OddState extends State {

    private static final long serialVersionUID = 1L;

    public OddState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public OddState(final OddState other) {
        super(other);
    }

    @Override public OddState copy() { return new OddState(this); }

}
