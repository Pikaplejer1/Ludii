package other.state.k;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Khamousiyya. */
public class KhamousiyyaState extends State {

    private static final long serialVersionUID = 1L;

    public KhamousiyyaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public KhamousiyyaState(final KhamousiyyaState other) {
        super(other);
    }

    @Override public KhamousiyyaState copy() { return new KhamousiyyaState(this); }

}
