package other.state.v;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Vertiges. */
public class VertigesState extends State {

    private static final long serialVersionUID = 1L;

    public VertigesState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public VertigesState(final VertigesState other) {
        super(other);
    }

    @Override public VertigesState copy() { return new VertigesState(this); }

}
