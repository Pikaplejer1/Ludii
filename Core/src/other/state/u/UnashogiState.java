package other.state.u;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Unashogi. */
public class UnashogiState extends State {

    private static final long serialVersionUID = 1L;

    public UnashogiState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public UnashogiState(final UnashogiState other) {
        super(other);
    }

    @Override public UnashogiState copy() { return new UnashogiState(this); }

}
