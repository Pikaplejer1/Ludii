package other.state.d;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for DoGuti. */
public class DoGutiState extends State {

    private static final long serialVersionUID = 1L;

    public DoGutiState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public DoGutiState(final DoGutiState other) {
        super(other);
    }

    @Override public DoGutiState copy() { return new DoGutiState(this); }

}
