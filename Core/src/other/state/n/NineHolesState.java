package other.state.n;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for NineHoles. */
public class NineHolesState extends State {

    private static final long serialVersionUID = 1L;

    public NineHolesState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public NineHolesState(final NineHolesState other) {
        super(other);
    }

    @Override public NineHolesState copy() { return new NineHolesState(this); }

}
