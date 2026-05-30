package other.state.m;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for MaoNagaTigerGame. */
public class MaoNagaTigerGameState extends State {

    private static final long serialVersionUID = 1L;

    public MaoNagaTigerGameState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public MaoNagaTigerGameState(final MaoNagaTigerGameState other) {
        super(other);
    }

    @Override public MaoNagaTigerGameState copy() { return new MaoNagaTigerGameState(this); }

}
