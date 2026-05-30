package other.state.n;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Notakto. */
public class NotaktoState extends State {

    private static final long serialVersionUID = 1L;

    public NotaktoState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public NotaktoState(final NotaktoState other) {
        super(other);
    }

    @Override public NotaktoState copy() { return new NotaktoState(this); }

}
