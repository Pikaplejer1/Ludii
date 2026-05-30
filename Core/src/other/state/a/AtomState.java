package other.state.a;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Atom. */
public class AtomState extends State {

    private static final long serialVersionUID = 1L;

    public AtomState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public AtomState(final AtomState other) {
        super(other);
    }

    @Override public AtomState copy() { return new AtomState(this); }

}
