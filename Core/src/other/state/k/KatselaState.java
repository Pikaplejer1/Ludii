package other.state.k;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Katsela. */
public class KatselaState extends State {

    private static final long serialVersionUID = 1L;

    public KatselaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public KatselaState(final KatselaState other) {
        super(other);
    }

    @Override public KatselaState copy() { return new KatselaState(this); }

}
