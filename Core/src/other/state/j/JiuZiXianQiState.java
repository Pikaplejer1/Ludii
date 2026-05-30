package other.state.j;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for JiuZiXianQi. */
public class JiuZiXianQiState extends State {

    private static final long serialVersionUID = 1L;

    public JiuZiXianQiState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public JiuZiXianQiState(final JiuZiXianQiState other) {
        super(other);
    }

    @Override public JiuZiXianQiState copy() { return new JiuZiXianQiState(this); }

}
