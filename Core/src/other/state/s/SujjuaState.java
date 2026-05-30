package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Sujjua. */
public class SujjuaState extends State {

    private static final long serialVersionUID = 1L;

    public SujjuaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SujjuaState(final SujjuaState other) {
        super(other);
    }

    @Override public SujjuaState copy() { return new SujjuaState(this); }

}
