package other.state.i;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Icosian. */
public class IcosianState extends State {

    private static final long serialVersionUID = 1L;

    public IcosianState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public IcosianState(final IcosianState other) {
        super(other);
    }

    @Override public IcosianState copy() { return new IcosianState(this); }

}
