package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Slimetrail. */
public class SlimetrailState extends State {

    private static final long serialVersionUID = 1L;

    public SlimetrailState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SlimetrailState(final SlimetrailState other) {
        super(other);
    }

    @Override public SlimetrailState copy() { return new SlimetrailState(this); }

}
