package other.state.n;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for NerenchiKeliya. */
public class NerenchiKeliyaState extends State {

    private static final long serialVersionUID = 1L;

    public NerenchiKeliyaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public NerenchiKeliyaState(final NerenchiKeliyaState other) {
        super(other);
    }

    @Override public NerenchiKeliyaState copy() { return new NerenchiKeliyaState(this); }

}
