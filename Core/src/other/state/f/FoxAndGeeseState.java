package other.state.f;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for FoxAndGeese. */
public class FoxAndGeeseState extends State {

    private static final long serialVersionUID = 1L;

    public FoxAndGeeseState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public FoxAndGeeseState(final FoxAndGeeseState other) {
        super(other);
    }

    @Override public FoxAndGeeseState copy() { return new FoxAndGeeseState(this); }

}
