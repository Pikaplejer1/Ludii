package other.state.e;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Elea. */
public class EleaState extends State {

    private static final long serialVersionUID = 1L;

    public EleaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public EleaState(final EleaState other) {
        super(other);
    }

    @Override public EleaState copy() { return new EleaState(this); }

}
