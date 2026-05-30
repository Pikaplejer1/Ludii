package other.state.e;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for EgaraGuti. */
public class EgaraGutiState extends State {

    private static final long serialVersionUID = 1L;

    public EgaraGutiState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public EgaraGutiState(final EgaraGutiState other) {
        super(other);
    }

    @Override public EgaraGutiState copy() { return new EgaraGutiState(this); }

}
