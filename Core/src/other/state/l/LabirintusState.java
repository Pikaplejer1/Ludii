package other.state.l;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Labirintus. */
public class LabirintusState extends State {

    private static final long serialVersionUID = 1L;

    public LabirintusState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public LabirintusState(final LabirintusState other) {
        super(other);
    }

    @Override public LabirintusState copy() { return new LabirintusState(this); }

}
