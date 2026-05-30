package other.state.a;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Aksadyuta. */
public class AksadyutaState extends State {

    private static final long serialVersionUID = 1L;

    public AksadyutaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public AksadyutaState(final AksadyutaState other) {
        super(other);
    }

    @Override public AksadyutaState copy() { return new AksadyutaState(this); }

}
