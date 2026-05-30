package other.state.f;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for FeedTheDucks. */
public class FeedTheDucksState extends State {

    private static final long serialVersionUID = 1L;

    public FeedTheDucksState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public FeedTheDucksState(final FeedTheDucksState other) {
        super(other);
    }

    @Override public FeedTheDucksState copy() { return new FeedTheDucksState(this); }

}
