package other.state.c;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Center. */
public class CenterState extends State {

    private static final long serialVersionUID = 1L;

    public CenterState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public CenterState(final CenterState other) {
        super(other);
    }

    @Override public CenterState copy() { return new CenterState(this); }

}
