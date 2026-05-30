package other.state.m;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for MorpionSolitaire. */
public class MorpionSolitaireState extends State {

    private static final long serialVersionUID = 1L;

    public MorpionSolitaireState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public MorpionSolitaireState(final MorpionSolitaireState other) {
        super(other);
    }

    @Override public MorpionSolitaireState copy() { return new MorpionSolitaireState(this); }

}
