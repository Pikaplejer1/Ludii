package other.state.a;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for AddiKul. */
public class AddiKulState extends State {

    private static final long serialVersionUID = 1L;

    public AddiKulState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public AddiKulState(final AddiKulState other) {
        super(other);
    }

    @Override public AddiKulState copy() { return new AddiKulState(this); }

}
