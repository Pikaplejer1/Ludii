package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for SpanRups. */
public class SpanRupsState extends State {

    private static final long serialVersionUID = 1L;

    public SpanRupsState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SpanRupsState(final SpanRupsState other) {
        super(other);
    }

    @Override public SpanRupsState copy() { return new SpanRupsState(this); }

}
