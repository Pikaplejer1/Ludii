package other.state.a;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for AlQirq. */
public class AlQirqState extends State {

    private static final long serialVersionUID = 1L;

    public AlQirqState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public AlQirqState(final AlQirqState other) {
        super(other);
    }

    @Override public AlQirqState copy() { return new AlQirqState(this); }

}
