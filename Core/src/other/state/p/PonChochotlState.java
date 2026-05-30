package other.state.p;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for PonChochotl. */
public class PonChochotlState extends State {

    private static final long serialVersionUID = 1L;

    public PonChochotlState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public PonChochotlState(final PonChochotlState other) {
        super(other);
    }

    @Override public PonChochotlState copy() { return new PonChochotlState(this); }

}
