package other.state.n;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Neutreeko. */
public class NeutreekoState extends State {

    private static final long serialVersionUID = 1L;

    public NeutreekoState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public NeutreekoState(final NeutreekoState other) {
        super(other);
    }

    @Override public NeutreekoState copy() { return new NeutreekoState(this); }

}
