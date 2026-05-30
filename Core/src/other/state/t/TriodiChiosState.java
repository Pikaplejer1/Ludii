package other.state.t;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for TriodiChios. */
public class TriodiChiosState extends State {

    private static final long serialVersionUID = 1L;

    public TriodiChiosState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public TriodiChiosState(final TriodiChiosState other) {
        super(other);
    }

    @Override public TriodiChiosState copy() { return new TriodiChiosState(this); }

}
