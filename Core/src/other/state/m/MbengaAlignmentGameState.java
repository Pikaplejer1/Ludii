package other.state.m;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for MbengaAlignmentGame. */
public class MbengaAlignmentGameState extends State {

    private static final long serialVersionUID = 1L;

    public MbengaAlignmentGameState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public MbengaAlignmentGameState(final MbengaAlignmentGameState other) {
        super(other);
    }

    @Override public MbengaAlignmentGameState copy() { return new MbengaAlignmentGameState(this); }

}
