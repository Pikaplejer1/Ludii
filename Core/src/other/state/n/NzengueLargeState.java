package other.state.n;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for NzengueLarge. */
public class NzengueLargeState extends State {

    private static final long serialVersionUID = 1L;

    public NzengueLargeState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public NzengueLargeState(final NzengueLargeState other) {
        super(other);
    }

    @Override public NzengueLargeState copy() { return new NzengueLargeState(this); }

}
