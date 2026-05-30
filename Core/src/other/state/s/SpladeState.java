package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Splade. */
public class SpladeState extends State {

    private static final long serialVersionUID = 1L;

    public SpladeState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SpladeState(final SpladeState other) {
        super(other);
    }

    @Override public SpladeState copy() { return new SpladeState(this); }

}
