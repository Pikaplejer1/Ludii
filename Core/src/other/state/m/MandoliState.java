package other.state.m;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Mandoli. */
public class MandoliState extends State {

    private static final long serialVersionUID = 1L;

    public MandoliState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public MandoliState(final MandoliState other) {
        super(other);
    }

    @Override public MandoliState copy() { return new MandoliState(this); }

}
