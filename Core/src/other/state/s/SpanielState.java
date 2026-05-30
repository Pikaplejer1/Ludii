package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Spaniel. */
public class SpanielState extends State {

    private static final long serialVersionUID = 1L;

    public SpanielState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SpanielState(final SpanielState other) {
        super(other);
    }

    @Override public SpanielState copy() { return new SpanielState(this); }

}
