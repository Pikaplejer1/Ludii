package other.state.t;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for ThreePlayerHex. */
public class ThreePlayerHexState extends State {

    private static final long serialVersionUID = 1L;

    public ThreePlayerHexState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public ThreePlayerHexState(final ThreePlayerHexState other) {
        super(other);
    }

    @Override public ThreePlayerHexState copy() { return new ThreePlayerHexState(this); }

}
