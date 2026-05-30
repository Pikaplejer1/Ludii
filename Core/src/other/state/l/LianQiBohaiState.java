package other.state.l;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for LianQiBohai. */
public class LianQiBohaiState extends State {

    private static final long serialVersionUID = 1L;

    public LianQiBohaiState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public LianQiBohaiState(final LianQiBohaiState other) {
        super(other);
    }

    @Override public LianQiBohaiState copy() { return new LianQiBohaiState(this); }

}
