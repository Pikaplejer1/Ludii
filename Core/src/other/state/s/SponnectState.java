package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Sponnect. */
public class SponnectState extends State {

    private static final long serialVersionUID = 1L;

    public SponnectState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SponnectState(final SponnectState other) {
        super(other);
    }

    @Override public SponnectState copy() { return new SponnectState(this); }

}
