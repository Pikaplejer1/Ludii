package other.state.t;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Tuknanavuhpi. */
public class TuknanavuhpiState extends State {

    private static final long serialVersionUID = 1L;

    public TuknanavuhpiState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public TuknanavuhpiState(final TuknanavuhpiState other) {
        super(other);
    }

    @Override public TuknanavuhpiState copy() { return new TuknanavuhpiState(this); }

}
