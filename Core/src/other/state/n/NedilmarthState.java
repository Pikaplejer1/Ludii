package other.state.n;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Nedilmarth. */
public class NedilmarthState extends State {

    private static final long serialVersionUID = 1L;

    public NedilmarthState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public NedilmarthState(final NedilmarthState other) {
        super(other);
    }

    @Override public NedilmarthState copy() { return new NedilmarthState(this); }

}
