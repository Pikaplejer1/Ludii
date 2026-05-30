package other.state.l;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Luuth. */
public class LuuthState extends State {

    private static final long serialVersionUID = 1L;

    public LuuthState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public LuuthState(final LuuthState other) {
        super(other);
    }

    @Override public LuuthState copy() { return new LuuthState(this); }

}
