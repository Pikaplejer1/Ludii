package other.state.t;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for TwoColour. */
public class TwoColourState extends State {

    private static final long serialVersionUID = 1L;

    public TwoColourState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public TwoColourState(final TwoColourState other) {
        super(other);
    }

    @Override public TwoColourState copy() { return new TwoColourState(this); }

}
