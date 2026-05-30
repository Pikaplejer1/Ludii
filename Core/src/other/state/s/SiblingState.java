package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Sibling. */
public class SiblingState extends State {

    private static final long serialVersionUID = 1L;

    public SiblingState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SiblingState(final SiblingState other) {
        super(other);
    }

    @Override public SiblingState copy() { return new SiblingState(this); }

}
