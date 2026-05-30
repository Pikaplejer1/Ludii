package other.state.k;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Kulaochal. */
public class KulaochalState extends State {

    private static final long serialVersionUID = 1L;

    public KulaochalState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public KulaochalState(final KulaochalState other) {
        super(other);
    }

    @Override public KulaochalState copy() { return new KulaochalState(this); }

}
