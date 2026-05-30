package other.state.d;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for DotsAndBoxes. */
public class DotsAndBoxesState extends State {

    private static final long serialVersionUID = 1L;

    public DotsAndBoxesState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public DotsAndBoxesState(final DotsAndBoxesState other) {
        super(other);
    }

    @Override public DotsAndBoxesState copy() { return new DotsAndBoxesState(this); }

}
