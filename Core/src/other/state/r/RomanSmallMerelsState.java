package other.state.r;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for RomanSmallMerels. */
public class RomanSmallMerelsState extends State {

    private static final long serialVersionUID = 1L;

    public RomanSmallMerelsState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public RomanSmallMerelsState(final RomanSmallMerelsState other) {
        super(other);
    }

    @Override public RomanSmallMerelsState copy() { return new RomanSmallMerelsState(this); }

}
