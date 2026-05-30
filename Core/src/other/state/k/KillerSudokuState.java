package other.state.k;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for KillerSudoku. */
public class KillerSudokuState extends State {

    private static final long serialVersionUID = 1L;

    public KillerSudokuState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public KillerSudokuState(final KillerSudokuState other) {
        super(other);
    }

    @Override public KillerSudokuState copy() { return new KillerSudokuState(this); }

}
