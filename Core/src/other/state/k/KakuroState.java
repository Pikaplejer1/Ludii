package other.state.k;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Kakuro. */
public class KakuroState extends State {

    private static final long serialVersionUID = 1L;

    public KakuroState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public KakuroState(final KakuroState other) {
        super(other);
    }

    @Override public KakuroState copy() { return new KakuroState(this); }

}
