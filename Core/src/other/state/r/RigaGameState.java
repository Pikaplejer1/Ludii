package other.state.r;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for RigaGame. */
public class RigaGameState extends State {

    private static final long serialVersionUID = 1L;

    public RigaGameState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public RigaGameState(final RigaGameState other) {
        super(other);
    }

    @Override public RigaGameState copy() { return new RigaGameState(this); }

}
