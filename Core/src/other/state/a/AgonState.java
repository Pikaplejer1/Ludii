package other.state.a;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Agon. */
public class AgonState extends State {

    private static final long serialVersionUID = 1L;

    public AgonState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public AgonState(final AgonState other) {
        super(other);
    }

    @Override public AgonState copy() { return new AgonState(this); }

}
