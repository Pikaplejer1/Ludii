package other.state.h;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for HyvnAetterHare. */
public class HyvnAetterHareState extends State {

    private static final long serialVersionUID = 1L;

    public HyvnAetterHareState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public HyvnAetterHareState(final HyvnAetterHareState other) {
        super(other);
    }

    @Override public HyvnAetterHareState copy() { return new HyvnAetterHareState(this); }

}
