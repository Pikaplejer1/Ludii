package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Spought. */
public class SpoughtState extends State {

    private static final long serialVersionUID = 1L;

    public SpoughtState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SpoughtState(final SpoughtState other) {
        super(other);
    }

    @Override public SpoughtState copy() { return new SpoughtState(this); }

}
