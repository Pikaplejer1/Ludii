package other.state.d;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Damspel. */
public class DamspelState extends State {

    private static final long serialVersionUID = 1L;

    public DamspelState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public DamspelState(final DamspelState other) {
        super(other);
    }

    @Override public DamspelState copy() { return new DamspelState(this); }

}
