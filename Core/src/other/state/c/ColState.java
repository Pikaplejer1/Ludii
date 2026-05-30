package other.state.c;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Col. */
public class ColState extends State {

    private static final long serialVersionUID = 1L;

    public ColState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public ColState(final ColState other) {
        super(other);
    }

    @Override public ColState copy() { return new ColState(this); }

}
