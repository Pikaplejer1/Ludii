package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Shatranj14x14. */
public class Shatranj14x14State extends State {

    private static final long serialVersionUID = 1L;

    public Shatranj14x14State(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public Shatranj14x14State(final Shatranj14x14State other) {
        super(other);
    }

    @Override public Shatranj14x14State copy() { return new Shatranj14x14State(this); }

}
