package other.state.j;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for JesonZam. */
public class JesonZamState extends State {

    private static final long serialVersionUID = 1L;

    public JesonZamState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public JesonZamState(final JesonZamState other) {
        super(other);
    }

    @Override public JesonZamState copy() { return new JesonZamState(this); }

}
