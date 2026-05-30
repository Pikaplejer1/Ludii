package other.state.k;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for KotuEllima. */
public class KotuEllimaState extends State {

    private static final long serialVersionUID = 1L;

    public KotuEllimaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public KotuEllimaState(final KotuEllimaState other) {
        super(other);
    }

    @Override public KotuEllimaState copy() { return new KotuEllimaState(this); }

}
