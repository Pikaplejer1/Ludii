package other.state.n;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Nuktagaq. */
public class NuktagaqState extends State {

    private static final long serialVersionUID = 1L;

    public NuktagaqState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public NuktagaqState(final NuktagaqState other) {
        super(other);
    }

    @Override public NuktagaqState copy() { return new NuktagaqState(this); }

}
