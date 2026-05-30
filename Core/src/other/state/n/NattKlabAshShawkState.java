package other.state.n;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for NattKlabAshShawk. */
public class NattKlabAshShawkState extends State {

    private static final long serialVersionUID = 1L;

    public NattKlabAshShawkState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public NattKlabAshShawkState(final NattKlabAshShawkState other) {
        super(other);
    }

    @Override public NattKlabAshShawkState copy() { return new NattKlabAshShawkState(this); }

}
