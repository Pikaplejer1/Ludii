package other.state.q;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for QueenSFour. */
public class QueenSFourState extends State {

    private static final long serialVersionUID = 1L;

    public QueenSFourState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public QueenSFourState(final QueenSFourState other) {
        super(other);
    }

    @Override public QueenSFourState copy() { return new QueenSFourState(this); }

}
