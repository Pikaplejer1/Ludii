package other.state.v;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for VaiLungThlan. */
public class VaiLungThlanState extends State {

    private static final long serialVersionUID = 1L;

    public VaiLungThlanState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public VaiLungThlanState(final VaiLungThlanState other) {
        super(other);
    }

    @Override public VaiLungThlanState copy() { return new VaiLungThlanState(this); }

}
