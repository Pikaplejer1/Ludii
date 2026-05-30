package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Spirit. */
public class SpiritState extends State {

    private static final long serialVersionUID = 1L;

    public SpiritState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SpiritState(final SpiritState other) {
        super(other);
    }

    @Override public SpiritState copy() { return new SpiritState(this); }

}
