package other.state.q;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for QelatBeniAmirMensa. */
public class QelatBeniAmirMensaState extends State {

    private static final long serialVersionUID = 1L;

    public QelatBeniAmirMensaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public QelatBeniAmirMensaState(final QelatBeniAmirMensaState other) {
        super(other);
    }

    @Override public QelatBeniAmirMensaState copy() { return new QelatBeniAmirMensaState(this); }

}
