package other.state.t;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for TsoroYemutatu. */
public class TsoroYemutatuState extends State {

    private static final long serialVersionUID = 1L;

    public TsoroYemutatuState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public TsoroYemutatuState(final TsoroYemutatuState other) {
        super(other);
    }

    @Override public TsoroYemutatuState copy() { return new TsoroYemutatuState(this); }

}
