package other.state.z;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Zonesh. */
public class ZoneshState extends State {

    private static final long serialVersionUID = 1L;

    public ZoneshState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public ZoneshState(final ZoneshState other) {
        super(other);
    }

    @Override public ZoneshState copy() { return new ZoneshState(this); }

}
