package other.state.m;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for MacBeth. */
public class MacBethState extends State {

    private static final long serialVersionUID = 1L;

    public MacBethState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public MacBethState(final MacBethState other) {
        super(other);
    }

    @Override public MacBethState copy() { return new MacBethState(this); }

}
