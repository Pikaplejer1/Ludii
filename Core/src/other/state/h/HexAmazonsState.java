package other.state.h;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for HexAmazons. */
public class HexAmazonsState extends State {

    private static final long serialVersionUID = 1L;

    public HexAmazonsState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public HexAmazonsState(final HexAmazonsState other) {
        super(other);
    }

    @Override public HexAmazonsState copy() { return new HexAmazonsState(this); }

}
