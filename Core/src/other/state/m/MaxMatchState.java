package other.state.m;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for MaxMatch. */
public class MaxMatchState extends State {

    private static final long serialVersionUID = 1L;

    public MaxMatchState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public MaxMatchState(final MaxMatchState other) {
        super(other);
    }

    @Override public MaxMatchState copy() { return new MaxMatchState(this); }

}
