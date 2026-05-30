package other.state.a;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Akidada. */
public class AkidadaState extends State {

    private static final long serialVersionUID = 1L;

    public AkidadaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public AkidadaState(final AkidadaState other) {
        super(other);
    }

    @Override public AkidadaState copy() { return new AkidadaState(this); }

}
