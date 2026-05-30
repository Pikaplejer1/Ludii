package other.state.r;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for RamTir. */
public class RamTirState extends State {

    private static final long serialVersionUID = 1L;

    public RamTirState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public RamTirState(final RamTirState other) {
        super(other);
    }

    @Override public RamTirState copy() { return new RamTirState(this); }

}
