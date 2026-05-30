package other.state.g;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for GolEkuish. */
public class GolEkuishState extends State {

    private static final long serialVersionUID = 1L;

    public GolEkuishState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public GolEkuishState(final GolEkuishState other) {
        super(other);
    }

    @Override public GolEkuishState copy() { return new GolEkuishState(this); }

}
