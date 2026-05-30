package other.state.l;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for LaChascona. */
public class LaChasconaState extends State {

    private static final long serialVersionUID = 1L;

    public LaChasconaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public LaChasconaState(final LaChasconaState other) {
        super(other);
    }

    @Override public LaChasconaState copy() { return new LaChasconaState(this); }

}
