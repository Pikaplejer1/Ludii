package other.state.a;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for AlmaTafl. */
public class AlmaTaflState extends State {

    private static final long serialVersionUID = 1L;

    public AlmaTaflState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public AlmaTaflState(final AlmaTaflState other) {
        super(other);
    }

    @Override public AlmaTaflState copy() { return new AlmaTaflState(this); }

}
