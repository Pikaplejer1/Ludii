package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for SabouIyya. */
public class SabouIyyaState extends State {

    private static final long serialVersionUID = 1L;

    public SabouIyyaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SabouIyyaState(final SabouIyyaState other) {
        super(other);
    }

    @Override public SabouIyyaState copy() { return new SabouIyyaState(this); }

}
