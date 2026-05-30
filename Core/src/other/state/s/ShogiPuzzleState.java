package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for ShogiPuzzle. */
public class ShogiPuzzleState extends State {

    private static final long serialVersionUID = 1L;

    public ShogiPuzzleState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public ShogiPuzzleState(final ShogiPuzzleState other) {
        super(other);
    }

    @Override public ShogiPuzzleState copy() { return new ShogiPuzzleState(this); }

}
