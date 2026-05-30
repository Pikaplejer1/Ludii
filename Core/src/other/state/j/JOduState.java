package other.state.j;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for JOdu. */
public class JOduState extends State {

    private static final long serialVersionUID = 1L;

    public JOduState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public JOduState(final JOduState other) {
        super(other);
    }

    @Override public JOduState copy() { return new JOduState(this); }

}
