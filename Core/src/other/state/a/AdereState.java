package other.state.a;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Adere. */
public class AdereState extends State {

    private static final long serialVersionUID = 1L;

    public AdereState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public AdereState(final AdereState other) {
        super(other);
    }

    @Override public AdereState copy() { return new AdereState(this); }

}
