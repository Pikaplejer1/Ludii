package other.state.j;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for JeuMilitaire. */
public class JeuMilitaireState extends State {

    private static final long serialVersionUID = 1L;

    public JeuMilitaireState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public JeuMilitaireState(final JeuMilitaireState other) {
        super(other);
    }

    @Override public JeuMilitaireState copy() { return new JeuMilitaireState(this); }

}
