package other.state.j;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for JeuDeRenard. */
public class JeuDeRenardState extends State {

    private static final long serialVersionUID = 1L;

    public JeuDeRenardState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public JeuDeRenardState(final JeuDeRenardState other) {
        super(other);
    }

    @Override public JeuDeRenardState copy() { return new JeuDeRenardState(this); }

}
