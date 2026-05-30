package other.state.q;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Quoridor. */
public class QuoridorState extends State {

    private static final long serialVersionUID = 1L;

    public QuoridorState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public QuoridorState(final QuoridorState other) {
        super(other);
    }

    @Override public QuoridorState copy() { return new QuoridorState(this); }

}
