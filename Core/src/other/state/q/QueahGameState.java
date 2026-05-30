package other.state.q;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for QueahGame. */
public class QueahGameState extends State {

    private static final long serialVersionUID = 1L;

    public QueahGameState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public QueahGameState(final QueahGameState other) {
        super(other);
    }

    @Override public QueahGameState copy() { return new QueahGameState(this); }

}
