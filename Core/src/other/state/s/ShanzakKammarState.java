package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for ShanzakKammar. */
public class ShanzakKammarState extends State {

    private static final long serialVersionUID = 1L;

    public ShanzakKammarState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public ShanzakKammarState(final ShanzakKammarState other) {
        super(other);
    }

    @Override public ShanzakKammarState copy() { return new ShanzakKammarState(this); }

}
