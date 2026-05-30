package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Santorini. */
public class SantoriniState extends State {

    private static final long serialVersionUID = 1L;

    public SantoriniState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SantoriniState(final SantoriniState other) {
        super(other);
    }

    @Override public SantoriniState copy() { return new SantoriniState(this); }

}
