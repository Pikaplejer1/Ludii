package other.state.y;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Yavalath. */
public class YavalathState extends State {

    private static final long serialVersionUID = 1L;

    public YavalathState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public YavalathState(final YavalathState other) {
        super(other);
    }

    @Override public YavalathState copy() { return new YavalathState(this); }

}
