package other.state.n;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Nsumbi. */
public class NsumbiState extends State {

    private static final long serialVersionUID = 1L;

    public NsumbiState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public NsumbiState(final NsumbiState other) {
        super(other);
    }

    @Override public NsumbiState copy() { return new NsumbiState(this); }

}
