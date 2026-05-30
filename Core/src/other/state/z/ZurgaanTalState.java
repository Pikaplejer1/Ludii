package other.state.z;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for ZurgaanTal. */
public class ZurgaanTalState extends State {

    private static final long serialVersionUID = 1L;

    public ZurgaanTalState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public ZurgaanTalState(final ZurgaanTalState other) {
        super(other);
    }

    @Override public ZurgaanTalState copy() { return new ZurgaanTalState(this); }

}
