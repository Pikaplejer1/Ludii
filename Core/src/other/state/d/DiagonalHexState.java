package other.state.d;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for DiagonalHex. */
public class DiagonalHexState extends State {

    private static final long serialVersionUID = 1L;

    public DiagonalHexState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public DiagonalHexState(final DiagonalHexState other) {
        super(other);
    }

    @Override public DiagonalHexState copy() { return new DiagonalHexState(this); }

}
