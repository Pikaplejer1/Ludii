package other.state.b;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for BaoKiArabuZanzibar2. */
public class BaoKiArabuZanzibar2State extends State {

    private static final long serialVersionUID = 1L;

    public BaoKiArabuZanzibar2State(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public BaoKiArabuZanzibar2State(final BaoKiArabuZanzibar2State other) {
        super(other);
    }

    @Override public BaoKiArabuZanzibar2State copy() { return new BaoKiArabuZanzibar2State(this); }

}
