package other.state.g;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Geister. */
public class GeisterState extends State {

    private static final long serialVersionUID = 1L;

    public GeisterState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public GeisterState(final GeisterState other) {
        super(other);
    }

    @Override public GeisterState copy() { return new GeisterState(this); }

}
