package other.state.u;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Unachess. */
public class UnachessState extends State {

    private static final long serialVersionUID = 1L;

    public UnachessState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public UnachessState(final UnachessState other) {
        super(other);
    }

    @Override public UnachessState copy() { return new UnachessState(this); }

}
