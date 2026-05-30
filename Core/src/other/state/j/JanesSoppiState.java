package other.state.j;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for JanesSoppi. */
public class JanesSoppiState extends State {

    private static final long serialVersionUID = 1L;

    public JanesSoppiState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public JanesSoppiState(final JanesSoppiState other) {
        super(other);
    }

    @Override public JanesSoppiState copy() { return new JanesSoppiState(this); }

}
