package other.state.g;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Gifia. */
public class GifiaState extends State {

    private static final long serialVersionUID = 1L;

    public GifiaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public GifiaState(final GifiaState other) {
        super(other);
    }

    @Override public GifiaState copy() { return new GifiaState(this); }

}
