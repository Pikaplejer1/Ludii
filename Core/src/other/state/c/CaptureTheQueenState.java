package other.state.c;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for CaptureTheQueen. */
public class CaptureTheQueenState extends State {

    private static final long serialVersionUID = 1L;

    public CaptureTheQueenState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public CaptureTheQueenState(final CaptureTheQueenState other) {
        super(other);
    }

    @Override public CaptureTheQueenState copy() { return new CaptureTheQueenState(this); }

}
