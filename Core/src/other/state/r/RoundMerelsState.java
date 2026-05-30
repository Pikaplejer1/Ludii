package other.state.r;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for RoundMerels. */
public class RoundMerelsState extends State {

    private static final long serialVersionUID = 1L;

    public RoundMerelsState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public RoundMerelsState(final RoundMerelsState other) {
        super(other);
    }

    @Override public RoundMerelsState copy() { return new RoundMerelsState(this); }

}
