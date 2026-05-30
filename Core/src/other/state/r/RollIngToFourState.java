package other.state.r;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for RollIngToFour. */
public class RollIngToFourState extends State {

    private static final long serialVersionUID = 1L;

    public RollIngToFourState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public RollIngToFourState(final RollIngToFourState other) {
        super(other);
    }

    @Override public RollIngToFourState copy() { return new RollIngToFourState(this); }

}
