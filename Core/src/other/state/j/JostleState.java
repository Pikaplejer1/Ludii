package other.state.j;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Jostle. */
public class JostleState extends State {

    private static final long serialVersionUID = 1L;

    public JostleState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public JostleState(final JostleState other) {
        super(other);
    }

    @Override public JostleState copy() { return new JostleState(this); }

}
