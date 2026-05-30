package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Seega. */
public class SeegaState extends State {

    private static final long serialVersionUID = 1L;

    public SeegaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SeegaState(final SeegaState other) {
        super(other);
    }

    @Override public SeegaState copy() { return new SeegaState(this); }

}
