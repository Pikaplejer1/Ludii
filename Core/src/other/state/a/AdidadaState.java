package other.state.a;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Adidada. */
public class AdidadaState extends State {

    private static final long serialVersionUID = 1L;

    public AdidadaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public AdidadaState(final AdidadaState other) {
        super(other);
    }

    @Override public AdidadaState copy() { return new AdidadaState(this); }

}
