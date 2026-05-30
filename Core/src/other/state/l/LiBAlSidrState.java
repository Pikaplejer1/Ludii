package other.state.l;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for LiBAlSidr. */
public class LiBAlSidrState extends State {

    private static final long serialVersionUID = 1L;

    public LiBAlSidrState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public LiBAlSidrState(final LiBAlSidrState other) {
        super(other);
    }

    @Override public LiBAlSidrState copy() { return new LiBAlSidrState(this); }

}
