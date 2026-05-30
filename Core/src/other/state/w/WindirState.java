package other.state.w;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Windir. */
public class WindirState extends State {

    private static final long serialVersionUID = 1L;

    public WindirState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public WindirState(final WindirState other) {
        super(other);
    }

    @Override public WindirState copy() { return new WindirState(this); }

}
