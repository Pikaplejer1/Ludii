package other.state.y;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Yavalade. */
public class YavaladeState extends State {

    private static final long serialVersionUID = 1L;

    public YavaladeState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public YavaladeState(final YavaladeState other) {
        super(other);
    }

    @Override public YavaladeState copy() { return new YavaladeState(this); }

}
