package other.state.o;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for OumoulKono. */
public class OumoulKonoState extends State {

    private static final long serialVersionUID = 1L;

    public OumoulKonoState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public OumoulKonoState(final OumoulKonoState other) {
        super(other);
    }

    @Override public OumoulKonoState copy() { return new OumoulKonoState(this); }

}
