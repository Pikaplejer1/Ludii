package other.state.a;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Adugo. */
public class AdugoState extends State {

    private static final long serialVersionUID = 1L;

    public AdugoState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public AdugoState(final AdugoState other) {
        super(other);
    }

    @Override public AdugoState copy() { return new AdugoState(this); }

}
