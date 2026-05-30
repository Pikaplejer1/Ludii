package other.state.l;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for LaBAkila. */
public class LaBAkilaState extends State {

    private static final long serialVersionUID = 1L;

    public LaBAkilaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public LaBAkilaState(final LaBAkilaState other) {
        super(other);
    }

    @Override public LaBAkilaState copy() { return new LaBAkilaState(this); }

}
