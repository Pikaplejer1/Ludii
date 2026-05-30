package other.state.k;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for KisoloLali. */
public class KisoloLaliState extends State {

    private static final long serialVersionUID = 1L;

    public KisoloLaliState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public KisoloLaliState(final KisoloLaliState other) {
        super(other);
    }

    @Override public KisoloLaliState copy() { return new KisoloLaliState(this); }

}
