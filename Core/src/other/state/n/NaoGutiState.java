package other.state.n;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for NaoGuti. */
public class NaoGutiState extends State {

    private static final long serialVersionUID = 1L;

    public NaoGutiState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public NaoGutiState(final NaoGutiState other) {
        super(other);
    }

    @Override public NaoGutiState copy() { return new NaoGutiState(this); }

}
