package other.state.k;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for KoAppPawNa. */
public class KoAppPawNaState extends State {

    private static final long serialVersionUID = 1L;

    public KoAppPawNaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public KoAppPawNaState(final KoAppPawNaState other) {
        super(other);
    }

    @Override public KoAppPawNaState copy() { return new KoAppPawNaState(this); }

}
