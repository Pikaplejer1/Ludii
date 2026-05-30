package other.state.m;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for MagicHexagon. */
public class MagicHexagonState extends State {

    private static final long serialVersionUID = 1L;

    public MagicHexagonState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public MagicHexagonState(final MagicHexagonState other) {
        super(other);
    }

    @Override public MagicHexagonState copy() { return new MagicHexagonState(this); }

}
