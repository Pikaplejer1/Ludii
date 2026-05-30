package other.state.t;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for TobiShogi. */
public class TobiShogiState extends State {

    private static final long serialVersionUID = 1L;

    public TobiShogiState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public TobiShogiState(final TobiShogiState other) {
        super(other);
    }

    @Override public TobiShogiState copy() { return new TobiShogiState(this); }

}
