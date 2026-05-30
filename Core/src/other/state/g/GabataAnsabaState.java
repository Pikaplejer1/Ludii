package other.state.g;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for GabataAnsaba. */
public class GabataAnsabaState extends State {

    private static final long serialVersionUID = 1L;

    public GabataAnsabaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public GabataAnsabaState(final GabataAnsabaState other) {
        super(other);
    }

    @Override public GabataAnsabaState copy() { return new GabataAnsabaState(this); }

}
