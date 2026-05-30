package other.state.o;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for OPatKono. */
public class OPatKonoState extends State {

    private static final long serialVersionUID = 1L;

    public OPatKonoState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public OPatKonoState(final OPatKonoState other) {
        super(other);
    }

    @Override public OPatKonoState copy() { return new OPatKonoState(this); }

}
