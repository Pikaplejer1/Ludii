package other.state.l;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for LiuTsi. */
public class LiuTsiState extends State {

    private static final long serialVersionUID = 1L;

    public LiuTsiState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public LiuTsiState(final LiuTsiState other) {
        super(other);
    }

    @Override public LiuTsiState copy() { return new LiuTsiState(this); }

}
