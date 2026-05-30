package other.state.n;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Ngrin. */
public class NgrinState extends State {

    private static final long serialVersionUID = 1L;

    public NgrinState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public NgrinState(final NgrinState other) {
        super(other);
    }

    @Override public NgrinState copy() { return new NgrinState(this); }

}
