package other.state.k;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Ketatu. */
public class KetatuState extends State {

    private static final long serialVersionUID = 1L;

    public KetatuState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public KetatuState(final KetatuState other) {
        super(other);
    }

    @Override public KetatuState copy() { return new KetatuState(this); }

}
