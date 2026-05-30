package other.state.c;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for CiriAmber. */
public class CiriAmberState extends State {

    private static final long serialVersionUID = 1L;

    public CiriAmberState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public CiriAmberState(final CiriAmberState other) {
        super(other);
    }

    @Override public CiriAmberState copy() { return new CiriAmberState(this); }

}
