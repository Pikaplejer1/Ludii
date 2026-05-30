package other.state.k;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for KapanaBona. */
public class KapanaBonaState extends State {

    private static final long serialVersionUID = 1L;

    public KapanaBonaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public KapanaBonaState(final KapanaBonaState other) {
        super(other);
    }

    @Override public KapanaBonaState copy() { return new KapanaBonaState(this); }

}
