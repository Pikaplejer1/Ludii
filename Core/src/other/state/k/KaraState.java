package other.state.k;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Kara. */
public class KaraState extends State {

    private static final long serialVersionUID = 1L;

    public KaraState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public KaraState(final KaraState other) {
        super(other);
    }

    @Override public KaraState copy() { return new KaraState(this); }

}
