package other.state.q;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Qatranj. */
public class QatranjState extends State {

    private static final long serialVersionUID = 1L;

    public QatranjState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public QatranjState(final QatranjState other) {
        super(other);
    }

    @Override public QatranjState copy() { return new QatranjState(this); }

}
