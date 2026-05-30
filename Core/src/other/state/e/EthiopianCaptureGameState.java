package other.state.e;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for EthiopianCaptureGame. */
public class EthiopianCaptureGameState extends State {

    private static final long serialVersionUID = 1L;

    public EthiopianCaptureGameState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public EthiopianCaptureGameState(final EthiopianCaptureGameState other) {
        super(other);
    }

    @Override public EthiopianCaptureGameState copy() { return new EthiopianCaptureGameState(this); }

}
