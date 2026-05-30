package other.state.d;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for DaiSeireigi. */
public class DaiSeireigiState extends State {

    private static final long serialVersionUID = 1L;

    public DaiSeireigiState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public DaiSeireigiState(final DaiSeireigiState other) {
        super(other);
    }

    @Override public DaiSeireigiState copy() { return new DaiSeireigiState(this); }

}
