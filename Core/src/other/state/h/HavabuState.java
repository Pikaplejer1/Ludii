package other.state.h;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Havabu. */
public class HavabuState extends State {

    private static final long serialVersionUID = 1L;

    public HavabuState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public HavabuState(final HavabuState other) {
        super(other);
    }

    @Override public HavabuState copy() { return new HavabuState(this); }

}
