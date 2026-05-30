package other.state.w;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for WolfUndSchaaf. */
public class WolfUndSchaafState extends State {

    private static final long serialVersionUID = 1L;

    public WolfUndSchaafState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public WolfUndSchaafState(final WolfUndSchaafState other) {
        super(other);
    }

    @Override public WolfUndSchaafState copy() { return new WolfUndSchaafState(this); }

}
