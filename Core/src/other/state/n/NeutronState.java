package other.state.n;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Neutron. */
public class NeutronState extends State {

    private static final long serialVersionUID = 1L;

    public NeutronState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public NeutronState(final NeutronState other) {
        super(other);
    }

    @Override public NeutronState copy() { return new NeutronState(this); }

}
