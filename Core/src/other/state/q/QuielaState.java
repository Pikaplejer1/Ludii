package other.state.q;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Quiela. */
public class QuielaState extends State {

    private static final long serialVersionUID = 1L;

    public QuielaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public QuielaState(final QuielaState other) {
        super(other);
    }

    @Override public QuielaState copy() { return new QuielaState(this); }

}
