package other.state.d;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Dodgem. */
public class DodgemState extends State {

    private static final long serialVersionUID = 1L;

    public DodgemState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public DodgemState(final DodgemState other) {
        super(other);
    }

    @Override public DodgemState copy() { return new DodgemState(this); }

}
