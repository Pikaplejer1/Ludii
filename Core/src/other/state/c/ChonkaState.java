package other.state.c;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Chonka. */
public class ChonkaState extends State {

    private static final long serialVersionUID = 1L;

    public ChonkaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public ChonkaState(final ChonkaState other) {
        super(other);
    }

    @Override public ChonkaState copy() { return new ChonkaState(this); }

}
