package other.state.a;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Archimedes. */
public class ArchimedesState extends State {

    private static final long serialVersionUID = 1L;

    public ArchimedesState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public ArchimedesState(final ArchimedesState other) {
        super(other);
    }

    @Override public ArchimedesState copy() { return new ArchimedesState(this); }

}
