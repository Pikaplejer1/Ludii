package other.state.d;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for DrisEtTessaDiagonals. */
public class DrisEtTessaDiagonalsState extends State {

    private static final long serialVersionUID = 1L;

    public DrisEtTessaDiagonalsState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public DrisEtTessaDiagonalsState(final DrisEtTessaDiagonalsState other) {
        super(other);
    }

    @Override public DrisEtTessaDiagonalsState copy() { return new DrisEtTessaDiagonalsState(this); }

}
