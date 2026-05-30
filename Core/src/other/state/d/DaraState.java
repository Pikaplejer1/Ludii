package other.state.d;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Dara. */
public class DaraState extends State {

    private static final long serialVersionUID = 1L;

    public DaraState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public DaraState(final DaraState other) {
        super(other);
    }

    @Override public DaraState copy() { return new DaraState(this); }

}
