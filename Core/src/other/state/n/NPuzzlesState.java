package other.state.n;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for NPuzzles. */
public class NPuzzlesState extends State {

    private static final long serialVersionUID = 1L;

    public NPuzzlesState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public NPuzzlesState(final NPuzzlesState other) {
        super(other);
    }

    @Override public NPuzzlesState copy() { return new NPuzzlesState(this); }

}
