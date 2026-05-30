package other.state.p;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Pula. */
public class PulaState extends State {

    private static final long serialVersionUID = 1L;

    public PulaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public PulaState(final PulaState other) {
        super(other);
    }

    @Override public PulaState copy() { return new PulaState(this); }

}
