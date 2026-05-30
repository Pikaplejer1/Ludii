package other.state.c;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for ChuSeireigi. */
public class ChuSeireigiState extends State {

    private static final long serialVersionUID = 1L;

    public ChuSeireigiState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public ChuSeireigiState(final ChuSeireigiState other) {
        super(other);
    }

    @Override public ChuSeireigiState copy() { return new ChuSeireigiState(this); }

}
