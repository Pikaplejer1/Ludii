package other.state.d;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Diagonals. */
public class DiagonalsState extends State {

    private static final long serialVersionUID = 1L;

    public DiagonalsState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public DiagonalsState(final DiagonalsState other) {
        super(other);
    }

    @Override public DiagonalsState copy() { return new DiagonalsState(this); }

}
