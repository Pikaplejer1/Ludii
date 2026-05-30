package other.state.g;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for GoldilocksStones. */
public class GoldilocksStonesState extends State {

    private static final long serialVersionUID = 1L;

    public GoldilocksStonesState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public GoldilocksStonesState(final GoldilocksStonesState other) {
        super(other);
    }

    @Override public GoldilocksStonesState copy() { return new GoldilocksStonesState(this); }

}
