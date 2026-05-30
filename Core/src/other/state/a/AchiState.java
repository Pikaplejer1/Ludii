package other.state.a;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Achi. */
public class AchiState extends State {

    private static final long serialVersionUID = 1L;

    public AchiState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public AchiState(final AchiState other) {
        super(other);
    }

    @Override public AchiState copy() { return new AchiState(this); }

}
