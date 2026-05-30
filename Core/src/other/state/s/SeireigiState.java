package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Seireigi. */
public class SeireigiState extends State {

    private static final long serialVersionUID = 1L;

    public SeireigiState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SeireigiState(final SeireigiState other) {
        super(other);
    }

    @Override public SeireigiState copy() { return new SeireigiState(this); }

}
