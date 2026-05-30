package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Sudoku. */
public class SudokuState extends State {

    private static final long serialVersionUID = 1L;

    public SudokuState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SudokuState(final SudokuState other) {
        super(other);
    }

    @Override public SudokuState copy() { return new SudokuState(this); }

}
