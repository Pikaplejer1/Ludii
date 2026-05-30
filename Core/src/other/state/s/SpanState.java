package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Span. */
public class SpanState extends State {

    private static final long serialVersionUID = 1L;

    public SpanState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SpanState(final SpanState other) {
        super(other);
    }

    @Override public SpanState copy() { return new SpanState(this); }

}
