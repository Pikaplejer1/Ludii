package other.state.a;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Atidada. */
public class AtidadaState extends State {

    private static final long serialVersionUID = 1L;

    public AtidadaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public AtidadaState(final AtidadaState other) {
        super(other);
    }

    @Override public AtidadaState copy() { return new AtidadaState(this); }

}
