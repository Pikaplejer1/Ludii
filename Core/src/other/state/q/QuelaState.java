package other.state.q;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Quela. */
public class QuelaState extends State {

    private static final long serialVersionUID = 1L;

    public QuelaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public QuelaState(final QuelaState other) {
        super(other);
    }

    @Override public QuelaState copy() { return new QuelaState(this); }

}
