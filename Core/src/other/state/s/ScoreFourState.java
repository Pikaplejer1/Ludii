package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for ScoreFour. */
public class ScoreFourState extends State {

    private static final long serialVersionUID = 1L;

    public ScoreFourState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public ScoreFourState(final ScoreFourState other) {
        super(other);
    }

    @Override public ScoreFourState copy() { return new ScoreFourState(this); }

}
