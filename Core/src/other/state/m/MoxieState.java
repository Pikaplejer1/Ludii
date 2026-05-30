package other.state.m;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Moxie. */
public class MoxieState extends State {

    private static final long serialVersionUID = 1L;

    public MoxieState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public MoxieState(final MoxieState other) {
        super(other);
    }

    @Override public MoxieState copy() { return new MoxieState(this); }

}
