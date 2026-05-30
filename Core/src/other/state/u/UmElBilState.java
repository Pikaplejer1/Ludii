package other.state.u;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for UmElBil. */
public class UmElBilState extends State {

    private static final long serialVersionUID = 1L;

    public UmElBilState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public UmElBilState(final UmElBilState other) {
        super(other);
    }

    @Override public UmElBilState copy() { return new UmElBilState(this); }

}
