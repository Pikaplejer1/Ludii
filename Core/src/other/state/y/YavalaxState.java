package other.state.y;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Yavalax. */
public class YavalaxState extends State {

    private static final long serialVersionUID = 1L;

    public YavalaxState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public YavalaxState(final YavalaxState other) {
        super(other);
    }

    @Override public YavalaxState copy() { return new YavalaxState(this); }

}
