package other.state.w;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for WariAlignment. */
public class WariAlignmentState extends State {

    private static final long serialVersionUID = 1L;

    public WariAlignmentState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public WariAlignmentState(final WariAlignmentState other) {
        super(other);
    }

    @Override public WariAlignmentState copy() { return new WariAlignmentState(this); }

}
