package other.state.r;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for RockPaperScissors. */
public class RockPaperScissorsState extends State {

    private static final long serialVersionUID = 1L;

    public RockPaperScissorsState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public RockPaperScissorsState(final RockPaperScissorsState other) {
        super(other);
    }

    @Override public RockPaperScissorsState copy() { return new RockPaperScissorsState(this); }

}
