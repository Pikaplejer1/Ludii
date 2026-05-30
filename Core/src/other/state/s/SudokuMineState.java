package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for SudokuMine. */
public class SudokuMineState extends State {

    private static final long serialVersionUID = 1L;

    public SudokuMineState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SudokuMineState(final SudokuMineState other) {
        super(other);
    }

    @Override public SudokuMineState copy() { return new SudokuMineState(this); }

}
