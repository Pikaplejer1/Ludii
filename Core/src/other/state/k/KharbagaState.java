package other.state.k;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Kharbaga. */
public class KharbagaState extends State {

    private static final long serialVersionUID = 1L;

    public KharbagaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public KharbagaState(final KharbagaState other) {
        super(other);
    }

    @Override public KharbagaState copy() { return new KharbagaState(this); }

}
