package other.state.o;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for OrderAndChaos. */
public class OrderAndChaosState extends State {

    private static final long serialVersionUID = 1L;

    public OrderAndChaosState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public OrderAndChaosState(final OrderAndChaosState other) {
        super(other);
    }

    @Override public OrderAndChaosState copy() { return new OrderAndChaosState(this); }

}
