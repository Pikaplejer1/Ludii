package other.state.a;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Adzua. */
public class AdzuaState extends State {

    private static final long serialVersionUID = 1L;

    public AdzuaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public AdzuaState(final AdzuaState other) {
        super(other);
    }

    @Override public AdzuaState copy() { return new AdzuaState(this); }

}
