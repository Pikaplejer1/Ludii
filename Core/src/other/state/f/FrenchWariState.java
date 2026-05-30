package other.state.f;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for FrenchWari. */
public class FrenchWariState extends State {

    private static final long serialVersionUID = 1L;

    public FrenchWariState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public FrenchWariState(final FrenchWariState other) {
        super(other);
    }

    @Override public FrenchWariState copy() { return new FrenchWariState(this); }

}
