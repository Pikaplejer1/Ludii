package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Shogi. */
public class ShogiState extends State {

    private static final long serialVersionUID = 1L;

    public ShogiState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public ShogiState(final ShogiState other) {
        super(other);
    }

    @Override public ShogiState copy() { return new ShogiState(this); }

}
