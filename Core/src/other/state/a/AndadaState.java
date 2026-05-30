package other.state.a;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Andada. */
public class AndadaState extends State {

    private static final long serialVersionUID = 1L;

    public AndadaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public AndadaState(final AndadaState other) {
        super(other);
    }

    @Override public AndadaState copy() { return new AndadaState(this); }

}
