package other.state.a;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for AntiKnightSudoku. */
public class AntiKnightSudokuState extends State {

    private static final long serialVersionUID = 1L;

    public AntiKnightSudokuState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public AntiKnightSudokuState(final AntiKnightSudokuState other) {
        super(other);
    }

    @Override public AntiKnightSudokuState copy() { return new AntiKnightSudokuState(this); }

}
