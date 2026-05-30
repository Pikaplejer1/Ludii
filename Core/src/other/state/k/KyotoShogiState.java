package other.state.k;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for KyotoShogi. */
public class KyotoShogiState extends State {

    private static final long serialVersionUID = 1L;

    public KyotoShogiState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public KyotoShogiState(final KyotoShogiState other) {
        super(other);
    }

    @Override public KyotoShogiState copy() { return new KyotoShogiState(this); }

}
