package other.state.c;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for CanTheSardines. */
public class CanTheSardinesState extends State {

    private static final long serialVersionUID = 1L;

    public CanTheSardinesState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public CanTheSardinesState(final CanTheSardinesState other) {
        super(other);
    }

    @Override public CanTheSardinesState copy() { return new CanTheSardinesState(this); }

}
