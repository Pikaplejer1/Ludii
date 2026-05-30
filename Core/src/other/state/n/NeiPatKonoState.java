package other.state.n;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for NeiPatKono. */
public class NeiPatKonoState extends State {

    private static final long serialVersionUID = 1L;

    public NeiPatKonoState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public NeiPatKonoState(final NeiPatKonoState other) {
        super(other);
    }

    @Override public NeiPatKonoState copy() { return new NeiPatKonoState(this); }

}
