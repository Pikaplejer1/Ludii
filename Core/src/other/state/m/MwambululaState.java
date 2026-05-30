package other.state.m;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Mwambulula. */
public class MwambululaState extends State {

    private static final long serialVersionUID = 1L;

    public MwambululaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public MwambululaState(final MwambululaState other) {
        super(other);
    }

    @Override public MwambululaState copy() { return new MwambululaState(this); }

}
