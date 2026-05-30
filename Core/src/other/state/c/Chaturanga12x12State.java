package other.state.c;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Chaturanga12x12. */
public class Chaturanga12x12State extends State {

    private static final long serialVersionUID = 1L;

    public Chaturanga12x12State(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public Chaturanga12x12State(final Chaturanga12x12State other) {
        super(other);
    }

    @Override public Chaturanga12x12State copy() { return new Chaturanga12x12State(this); }

}
