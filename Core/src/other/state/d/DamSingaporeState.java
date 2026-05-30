package other.state.d;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for DamSingapore. */
public class DamSingaporeState extends State {

    private static final long serialVersionUID = 1L;

    public DamSingaporeState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public DamSingaporeState(final DamSingaporeState other) {
        super(other);
    }

    @Override public DamSingaporeState copy() { return new DamSingaporeState(this); }

}
