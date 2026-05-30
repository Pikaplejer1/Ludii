package other.state.c;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Complica. */
public class ComplicaState extends State {

    private static final long serialVersionUID = 1L;

    public ComplicaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public ComplicaState(final ComplicaState other) {
        super(other);
    }

    @Override public ComplicaState copy() { return new ComplicaState(this); }

}
