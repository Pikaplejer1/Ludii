package other.state.m;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for MrahaWaBwe. */
public class MrahaWaBweState extends State {

    private static final long serialVersionUID = 1L;

    public MrahaWaBweState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public MrahaWaBweState(final MrahaWaBweState other) {
        super(other);
    }

    @Override public MrahaWaBweState copy() { return new MrahaWaBweState(this); }

}
