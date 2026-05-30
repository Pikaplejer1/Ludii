package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for SanNokuNarabe. */
public class SanNokuNarabeState extends State {

    private static final long serialVersionUID = 1L;

    public SanNokuNarabeState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SanNokuNarabeState(final SanNokuNarabeState other) {
        super(other);
    }

    @Override public SanNokuNarabeState copy() { return new SanNokuNarabeState(this); }

}
