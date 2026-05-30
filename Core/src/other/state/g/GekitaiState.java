package other.state.g;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Gekitai. */
public class GekitaiState extends State {

    private static final long serialVersionUID = 1L;

    public GekitaiState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public GekitaiState(final GekitaiState other) {
        super(other);
    }

    @Override public GekitaiState copy() { return new GekitaiState(this); }

}
