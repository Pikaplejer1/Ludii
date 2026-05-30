package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Shono. */
public class ShonoState extends State {

    private static final long serialVersionUID = 1L;

    public ShonoState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public ShonoState(final ShonoState other) {
        super(other);
    }

    @Override public ShonoState copy() { return new ShonoState(this); }

}
