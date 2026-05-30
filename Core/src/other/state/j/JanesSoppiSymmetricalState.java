package other.state.j;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for JanesSoppiSymmetrical. */
public class JanesSoppiSymmetricalState extends State {

    private static final long serialVersionUID = 1L;

    public JanesSoppiSymmetricalState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public JanesSoppiSymmetricalState(final JanesSoppiSymmetricalState other) {
        super(other);
    }

    @Override public JanesSoppiSymmetricalState copy() { return new JanesSoppiSymmetricalState(this); }

}
