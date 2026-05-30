package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Spodd. */
public class SpoddState extends State {

    private static final long serialVersionUID = 1L;

    public SpoddState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SpoddState(final SpoddState other) {
        super(other);
    }

    @Override public SpoddState copy() { return new SpoddState(this); }

}
