package other.state.a;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Amazons. */
public class AmazonsState extends State {

    private static final long serialVersionUID = 1L;

    public AmazonsState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public AmazonsState(final AmazonsState other) {
        super(other);
    }

    @Override public AmazonsState copy() { return new AmazonsState(this); }

}
