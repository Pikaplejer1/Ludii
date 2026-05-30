package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for SudokuX. */
public class SudokuXState extends State {

    private static final long serialVersionUID = 1L;

    public SudokuXState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SudokuXState(final SudokuXState other) {
        super(other);
    }

    @Override public SudokuXState copy() { return new SudokuXState(this); }

}
