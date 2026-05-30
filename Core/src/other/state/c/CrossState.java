package other.state.c;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Cross. */
public class CrossState extends State {

    private static final long serialVersionUID = 1L;

    public CrossState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public CrossState(final CrossState other) {
        super(other);
    }

    @Override public CrossState copy() { return new CrossState(this); }

}
