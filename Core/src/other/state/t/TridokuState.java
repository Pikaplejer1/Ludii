package other.state.t;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Tridoku. */
public class TridokuState extends State {

    private static final long serialVersionUID = 1L;

    public TridokuState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public TridokuState(final TridokuState other) {
        super(other);
    }

    @Override public TridokuState copy() { return new TridokuState(this); }

}
