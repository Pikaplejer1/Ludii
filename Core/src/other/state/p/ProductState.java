package other.state.p;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Product. */
public class ProductState extends State {

    private static final long serialVersionUID = 1L;

    public ProductState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public ProductState(final ProductState other) {
        super(other);
    }

    @Override public ProductState copy() { return new ProductState(this); }

}
