package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Shatranj12x12. */
public class Shatranj12x12State extends State {

    private static final long serialVersionUID = 1L;

    public Shatranj12x12State(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public Shatranj12x12State(final Shatranj12x12State other) {
        super(other);
    }

    @Override public Shatranj12x12State copy() { return new Shatranj12x12State(this); }

}
