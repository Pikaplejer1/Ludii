package other.state.m;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Moruba. */
public class MorubaState extends State {

    private static final long serialVersionUID = 1L;

    public MorubaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public MorubaState(final MorubaState other) {
        super(other);
    }

    @Override public MorubaState copy() { return new MorubaState(this); }

}
