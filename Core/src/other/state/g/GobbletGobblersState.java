package other.state.g;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for GobbletGobblers. */
public class GobbletGobblersState extends State {

    private static final long serialVersionUID = 1L;

    public GobbletGobblersState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public GobbletGobblersState(final GobbletGobblersState other) {
        super(other);
    }

    @Override public GobbletGobblersState copy() { return new GobbletGobblersState(this); }

}
