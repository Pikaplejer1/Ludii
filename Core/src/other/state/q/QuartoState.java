package other.state.q;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Quarto. */
public class QuartoState extends State {

    private static final long serialVersionUID = 1L;

    public QuartoState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public QuartoState(final QuartoState other) {
        super(other);
    }

    @Override public QuartoState copy() { return new QuartoState(this); }

}
