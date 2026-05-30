package other.state.l;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for LesPendus. */
public class LesPendusState extends State {

    private static final long serialVersionUID = 1L;

    public LesPendusState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public LesPendusState(final LesPendusState other) {
        super(other);
    }

    @Override public LesPendusState copy() { return new LesPendusState(this); }

}
