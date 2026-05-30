package other.state.f;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for FlowerShop. */
public class FlowerShopState extends State {

    private static final long serialVersionUID = 1L;

    public FlowerShopState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public FlowerShopState(final FlowerShopState other) {
        super(other);
    }

    @Override public FlowerShopState copy() { return new FlowerShopState(this); }

}
