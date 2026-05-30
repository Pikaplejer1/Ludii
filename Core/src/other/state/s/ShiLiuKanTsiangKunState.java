package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for ShiLiuKanTsiangKun. */
public class ShiLiuKanTsiangKunState extends State {

    private static final long serialVersionUID = 1L;

    public ShiLiuKanTsiangKunState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public ShiLiuKanTsiangKunState(final ShiLiuKanTsiangKunState other) {
        super(other);
    }

    @Override public ShiLiuKanTsiangKunState copy() { return new ShiLiuKanTsiangKunState(this); }

}
