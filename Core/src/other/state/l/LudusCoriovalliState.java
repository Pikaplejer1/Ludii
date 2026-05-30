package other.state.l;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for LudusCoriovalli. */
public class LudusCoriovalliState extends State {

    private static final long serialVersionUID = 1L;

    public LudusCoriovalliState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public LudusCoriovalliState(final LudusCoriovalliState other) {
        super(other);
    }

    @Override public LudusCoriovalliState copy() { return new LudusCoriovalliState(this); }

}
