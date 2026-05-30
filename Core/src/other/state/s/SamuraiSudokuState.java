package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for SamuraiSudoku. */
public class SamuraiSudokuState extends State {

    private static final long serialVersionUID = 1L;

    public SamuraiSudokuState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SamuraiSudokuState(final SamuraiSudokuState other) {
        super(other);
    }

    @Override public SamuraiSudokuState copy() { return new SamuraiSudokuState(this); }

}
