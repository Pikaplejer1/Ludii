package other.state.c;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Chongka. */
public class ChongkaState extends State {

    private static final long serialVersionUID = 1L;

    public ChongkaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public ChongkaState(final ChongkaState other) {
        super(other);
    }

    @Override public ChongkaState copy() { return new ChongkaState(this); }

}
