package other.state.a;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Abande. */
public class AbandeState extends State {

    private static final long serialVersionUID = 1L;

    public AbandeState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public AbandeState(final AbandeState other) {
        super(other);
    }

    @Override public AbandeState copy() { return new AbandeState(this); }

}
