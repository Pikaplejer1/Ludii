package other.state.r;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Reversi. */
public class ReversiState extends State {

    private static final long serialVersionUID = 1L;

    public ReversiState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public ReversiState(final ReversiState other) {
        super(other);
    }

    @Override public ReversiState copy() { return new ReversiState(this); }

}
