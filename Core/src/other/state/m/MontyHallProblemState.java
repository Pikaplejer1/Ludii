package other.state.m;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for MontyHallProblem. */
public class MontyHallProblemState extends State {

    private static final long serialVersionUID = 1L;

    public MontyHallProblemState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public MontyHallProblemState(final MontyHallProblemState other) {
        super(other);
    }

    @Override public MontyHallProblemState copy() { return new MontyHallProblemState(this); }

}
