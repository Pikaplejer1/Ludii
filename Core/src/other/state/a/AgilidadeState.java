package other.state.a;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Agilidade. */
public class AgilidadeState extends State {

    private static final long serialVersionUID = 1L;

    public AgilidadeState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public AgilidadeState(final AgilidadeState other) {
        super(other);
    }

    @Override public AgilidadeState copy() { return new AgilidadeState(this); }

}
