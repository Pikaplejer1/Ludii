package other.state.p;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Pentomino. */
public class PentominoState extends State {

    private static final long serialVersionUID = 1L;

    public PentominoState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public PentominoState(final PentominoState other) {
        super(other);
    }

    @Override public PentominoState copy() { return new PentominoState(this); }

}
