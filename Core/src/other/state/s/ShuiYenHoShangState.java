package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for ShuiYenHoShang. */
public class ShuiYenHoShangState extends State {

    private static final long serialVersionUID = 1L;

    public ShuiYenHoShangState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public ShuiYenHoShangState(final ShuiYenHoShangState other) {
        super(other);
    }

    @Override public ShuiYenHoShangState copy() { return new ShuiYenHoShangState(this); }

}
