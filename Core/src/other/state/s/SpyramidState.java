package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Spyramid. */
public class SpyramidState extends State {

    private static final long serialVersionUID = 1L;

    public SpyramidState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SpyramidState(final SpyramidState other) {
        super(other);
    }

    @Override public SpyramidState copy() { return new SpyramidState(this); }

}
