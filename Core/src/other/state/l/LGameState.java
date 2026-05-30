package other.state.l;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for LGame. */
public class LGameState extends State {

    private static final long serialVersionUID = 1L;

    public LGameState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public LGameState(final LGameState other) {
        super(other);
    }

    @Override public LGameState copy() { return new LGameState(this); }

}
