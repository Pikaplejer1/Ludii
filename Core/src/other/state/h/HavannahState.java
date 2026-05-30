package other.state.h;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Havannah. */
public class HavannahState extends State {

    private static final long serialVersionUID = 1L;

    public HavannahState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public HavannahState(final HavannahState other) {
        super(other);
    }

    @Override public HavannahState copy() { return new HavannahState(this); }

}
