package other.state.a;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for AncientMerels. */
public class AncientMerelsState extends State {

    private static final long serialVersionUID = 1L;

    public AncientMerelsState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public AncientMerelsState(final AncientMerelsState other) {
        super(other);
    }

    @Override public AncientMerelsState copy() { return new AncientMerelsState(this); }

}
