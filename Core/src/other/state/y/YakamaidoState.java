package other.state.y;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Yakamaido. */
public class YakamaidoState extends State {

    private static final long serialVersionUID = 1L;

    public YakamaidoState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public YakamaidoState(final YakamaidoState other) {
        super(other);
    }

    @Override public YakamaidoState copy() { return new YakamaidoState(this); }

}
