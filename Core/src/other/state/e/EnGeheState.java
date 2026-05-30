package other.state.e;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for EnGehe. */
public class EnGeheState extends State {

    private static final long serialVersionUID = 1L;

    public EnGeheState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public EnGeheState(final EnGeheState other) {
        super(other);
    }

    @Override public EnGeheState copy() { return new EnGeheState(this); }

}
