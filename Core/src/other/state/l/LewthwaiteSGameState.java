package other.state.l;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for LewthwaiteSGame. */
public class LewthwaiteSGameState extends State {

    private static final long serialVersionUID = 1L;

    public LewthwaiteSGameState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public LewthwaiteSGameState(final LewthwaiteSGameState other) {
        super(other);
    }

    @Override public LewthwaiteSGameState copy() { return new LewthwaiteSGameState(this); }

}
