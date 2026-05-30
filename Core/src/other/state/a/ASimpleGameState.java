package other.state.a;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for ASimpleGame. */
public class ASimpleGameState extends State {

    private static final long serialVersionUID = 1L;

    public ASimpleGameState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public ASimpleGameState(final ASimpleGameState other) {
        super(other);
    }

    @Override public ASimpleGameState copy() { return new ASimpleGameState(this); }

}
