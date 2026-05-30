package other.state.a;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Altiev. */
public class AltievState extends State {

    private static final long serialVersionUID = 1L;

    public AltievState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public AltievState(final AltievState other) {
        super(other);
    }

    @Override public AltievState copy() { return new AltievState(this); }

}
