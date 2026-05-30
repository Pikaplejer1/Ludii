package other.state.k;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for KnightSTour. */
public class KnightSTourState extends State {

    private static final long serialVersionUID = 1L;

    public KnightSTourState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public KnightSTourState(final KnightSTourState other) {
        super(other);
    }

    @Override public KnightSTourState copy() { return new KnightSTourState(this); }

}
