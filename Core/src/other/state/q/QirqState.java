package other.state.q;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Qirq. */
public class QirqState extends State {

    private static final long serialVersionUID = 1L;

    public QirqState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public QirqState(final QirqState other) {
        super(other);
    }

    @Override public QirqState copy() { return new QirqState(this); }

}
