package other.state.d;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Driesticken. */
public class DriestickenState extends State {

    private static final long serialVersionUID = 1L;

    public DriestickenState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public DriestickenState(final DriestickenState other) {
        super(other);
    }

    @Override public DriestickenState copy() { return new DriestickenState(this); }

}
