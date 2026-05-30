package other.state.d;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for DamaPhilippines. */
public class DamaPhilippinesState extends State {

    private static final long serialVersionUID = 1L;

    public DamaPhilippinesState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public DamaPhilippinesState(final DamaPhilippinesState other) {
        super(other);
    }

    @Override public DamaPhilippinesState copy() { return new DamaPhilippinesState(this); }

}
