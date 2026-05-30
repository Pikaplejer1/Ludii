package other.state.n;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for NegTugalTuux. */
public class NegTugalTuuxState extends State {

    private static final long serialVersionUID = 1L;

    public NegTugalTuuxState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public NegTugalTuuxState(final NegTugalTuuxState other) {
        super(other);
    }

    @Override public NegTugalTuuxState copy() { return new NegTugalTuuxState(this); }

}
