package other.state.t;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Teeko. */
public class TeekoState extends State {

    private static final long serialVersionUID = 1L;

    public TeekoState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public TeekoState(final TeekoState other) {
        super(other);
    }

    @Override public TeekoState copy() { return new TeekoState(this); }

}
