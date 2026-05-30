package other.state.h;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for HundEfterHareThy. */
public class HundEfterHareThyState extends State {

    private static final long serialVersionUID = 1L;

    public HundEfterHareThyState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public HundEfterHareThyState(final HundEfterHareThyState other) {
        super(other);
    }

    @Override public HundEfterHareThyState copy() { return new HundEfterHareThyState(this); }

}
