package other.state.r;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for RomanMerels. */
public class RomanMerelsState extends State {

    private static final long serialVersionUID = 1L;

    public RomanMerelsState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public RomanMerelsState(final RomanMerelsState other) {
        super(other);
    }

    @Override public RomanMerelsState copy() { return new RomanMerelsState(this); }

}
