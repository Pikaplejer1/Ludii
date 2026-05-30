package other.state.r;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for RongmeiNagaAlignmentGame. */
public class RongmeiNagaAlignmentGameState extends State {

    private static final long serialVersionUID = 1L;

    public RongmeiNagaAlignmentGameState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public RongmeiNagaAlignmentGameState(final RongmeiNagaAlignmentGameState other) {
        super(other);
    }

    @Override public RongmeiNagaAlignmentGameState copy() { return new RongmeiNagaAlignmentGameState(this); }

}
