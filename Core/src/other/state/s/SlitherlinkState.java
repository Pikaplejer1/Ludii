package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Slitherlink. */
public class SlitherlinkState extends State {

    private static final long serialVersionUID = 1L;

    public SlitherlinkState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SlitherlinkState(final SlitherlinkState other) {
        super(other);
    }

    @Override public SlitherlinkState copy() { return new SlitherlinkState(this); }

}
