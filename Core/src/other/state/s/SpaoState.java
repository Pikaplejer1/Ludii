package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Spao. */
public class SpaoState extends State {

    private static final long serialVersionUID = 1L;

    public SpaoState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SpaoState(final SpaoState other) {
        super(other);
    }

    @Override public SpaoState copy() { return new SpaoState(this); }

}
