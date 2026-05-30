package other.state.t;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Tumbleweed. */
public class TumbleweedState extends State {

    private static final long serialVersionUID = 1L;

    public TumbleweedState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public TumbleweedState(final TumbleweedState other) {
        super(other);
    }

    @Override public TumbleweedState copy() { return new TumbleweedState(this); }

}
