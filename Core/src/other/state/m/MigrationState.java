package other.state.m;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Migration. */
public class MigrationState extends State {

    private static final long serialVersionUID = 1L;

    public MigrationState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public MigrationState(final MigrationState other) {
        super(other);
    }

    @Override public MigrationState copy() { return new MigrationState(this); }

}
