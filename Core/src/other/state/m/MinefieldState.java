package other.state.m;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Minefield. */
public class MinefieldState extends State {

    private static final long serialVersionUID = 1L;

    public MinefieldState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public MinefieldState(final MinefieldState other) {
        super(other);
    }

    @Override public MinefieldState copy() { return new MinefieldState(this); }

}
