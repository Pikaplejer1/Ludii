package other.state.a;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for AltanXaraacaj. */
public class AltanXaraacajState extends State {

    private static final long serialVersionUID = 1L;

    public AltanXaraacajState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public AltanXaraacajState(final AltanXaraacajState other) {
        super(other);
    }

    @Override public AltanXaraacajState copy() { return new AltanXaraacajState(this); }

}
