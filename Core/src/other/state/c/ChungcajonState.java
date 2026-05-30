package other.state.c;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Chungcajon. */
public class ChungcajonState extends State {

    private static final long serialVersionUID = 1L;

    public ChungcajonState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public ChungcajonState(final ChungcajonState other) {
        super(other);
    }

    @Override public ChungcajonState copy() { return new ChungcajonState(this); }

}
