package other.state.e;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for EsaHex. */
public class EsaHexState extends State {

    private static final long serialVersionUID = 1L;

    public EsaHexState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public EsaHexState(final EsaHexState other) {
        super(other);
    }

    @Override public EsaHexState copy() { return new EsaHexState(this); }

}
