package other.state.l;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for LoopXiangqi. */
public class LoopXiangqiState extends State {

    private static final long serialVersionUID = 1L;

    public LoopXiangqiState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public LoopXiangqiState(final LoopXiangqiState other) {
        super(other);
    }

    @Override public LoopXiangqiState copy() { return new LoopXiangqiState(this); }

}
