package other.state.t;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for TicTactics. */
public class TicTacticsState extends State {

    private static final long serialVersionUID = 1L;

    public TicTacticsState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public TicTacticsState(final TicTacticsState other) {
        super(other);
    }

    @Override public TicTacticsState copy() { return new TicTacticsState(this); }

}
