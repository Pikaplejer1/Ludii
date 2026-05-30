package other.state.o;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Otep. */
public class OtepState extends State {

    private static final long serialVersionUID = 1L;

    public OtepState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public OtepState(final OtepState other) {
        super(other);
    }

    @Override public OtepState copy() { return new OtepState(this); }

}
