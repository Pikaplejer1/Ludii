package other.state.i;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Infuse. */
public class InfuseState extends State {

    private static final long serialVersionUID = 1L;

    public InfuseState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public InfuseState(final InfuseState other) {
        super(other);
    }

    @Override public InfuseState copy() { return new InfuseState(this); }

}
