package other.state.c;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Celticator. */
public class CelticatorState extends State {

    private static final long serialVersionUID = 1L;

    public CelticatorState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public CelticatorState(final CelticatorState other) {
        super(other);
    }

    @Override public CelticatorState copy() { return new CelticatorState(this); }

}
