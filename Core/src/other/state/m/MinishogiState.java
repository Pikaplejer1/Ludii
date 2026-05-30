package other.state.m;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Minishogi. */
public class MinishogiState extends State {

    private static final long serialVersionUID = 1L;

    public MinishogiState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public MinishogiState(final MinishogiState other) {
        super(other);
    }

    @Override public MinishogiState copy() { return new MinishogiState(this); }

}
