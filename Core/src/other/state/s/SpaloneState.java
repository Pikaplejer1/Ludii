package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Spalone. */
public class SpaloneState extends State {

    private static final long serialVersionUID = 1L;

    public SpaloneState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SpaloneState(final SpaloneState other) {
        super(other);
    }

    @Override public SpaloneState copy() { return new SpaloneState(this); }

}
