package other.state.j;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for JurokuMusashi. */
public class JurokuMusashiState extends State {

    private static final long serialVersionUID = 1L;

    public JurokuMusashiState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public JurokuMusashiState(final JurokuMusashiState other) {
        super(other);
    }

    @Override public JurokuMusashiState copy() { return new JurokuMusashiState(this); }

}
