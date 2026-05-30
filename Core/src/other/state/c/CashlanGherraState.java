package other.state.c;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for CashlanGherra. */
public class CashlanGherraState extends State {

    private static final long serialVersionUID = 1L;

    public CashlanGherraState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public CashlanGherraState(final CashlanGherraState other) {
        super(other);
    }

    @Override public CashlanGherraState copy() { return new CashlanGherraState(this); }

}
