package other.state.j;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for JeuDeRenardTwoFoxes. */
public class JeuDeRenardTwoFoxesState extends State {

    private static final long serialVersionUID = 1L;

    public JeuDeRenardTwoFoxesState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public JeuDeRenardTwoFoxesState(final JeuDeRenardTwoFoxesState other) {
        super(other);
    }

    @Override public JeuDeRenardTwoFoxesState copy() { return new JeuDeRenardTwoFoxesState(this); }

}
