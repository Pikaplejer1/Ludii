package other.state.e;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for ElMthaltha. */
public class ElMthalthaState extends State {

    private static final long serialVersionUID = 1L;

    public ElMthalthaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public ElMthalthaState(final ElMthalthaState other) {
        super(other);
    }

    @Override public ElMthalthaState copy() { return new ElMthalthaState(this); }

}
