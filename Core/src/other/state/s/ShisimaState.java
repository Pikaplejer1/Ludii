package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Shisima. */
public class ShisimaState extends State {

    private static final long serialVersionUID = 1L;

    public ShisimaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public ShisimaState(final ShisimaState other) {
        super(other);
    }

    @Override public ShisimaState copy() { return new ShisimaState(this); }

}
