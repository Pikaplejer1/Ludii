package other.state.a;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Awari. */
public class AwariState extends State {

    private static final long serialVersionUID = 1L;

    public AwariState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public AwariState(final AwariState other) {
        super(other);
    }

    @Override public AwariState copy() { return new AwariState(this); }

}
