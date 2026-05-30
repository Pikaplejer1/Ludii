package other.state.i;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Inkblots. */
public class InkblotsState extends State {

    private static final long serialVersionUID = 1L;

    public InkblotsState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public InkblotsState(final InkblotsState other) {
        super(other);
    }

    @Override public InkblotsState copy() { return new InkblotsState(this); }

}
