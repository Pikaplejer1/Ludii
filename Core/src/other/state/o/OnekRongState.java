package other.state.o;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for OnekRong. */
public class OnekRongState extends State {

    private static final long serialVersionUID = 1L;

    public OnekRongState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public OnekRongState(final OnekRongState other) {
        super(other);
    }

    @Override public OnekRongState copy() { return new OnekRongState(this); }

}
