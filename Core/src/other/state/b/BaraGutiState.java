package other.state.b;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for BaraGuti. */
public class BaraGutiState extends State {

    private static final long serialVersionUID = 1L;

    public BaraGutiState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public BaraGutiState(final BaraGutiState other) {
        super(other);
    }

    @Override public BaraGutiState copy() { return new BaraGutiState(this); }

}
