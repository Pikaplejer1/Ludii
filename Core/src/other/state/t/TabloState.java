package other.state.t;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Tablo. */
public class TabloState extends State {

    private static final long serialVersionUID = 1L;

    public TabloState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public TabloState(final TabloState other) {
        super(other);
    }

    @Override public TabloState copy() { return new TabloState(this); }

}
