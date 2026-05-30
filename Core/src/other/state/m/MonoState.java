package other.state.m;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Mono. */
public class MonoState extends State {

    private static final long serialVersionUID = 1L;

    public MonoState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public MonoState(final MonoState other) {
        super(other);
    }

    @Override public MonoState copy() { return new MonoState(this); }

}
