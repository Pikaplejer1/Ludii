package other.state.y;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Yavalanchor. */
public class YavalanchorState extends State {

    private static final long serialVersionUID = 1L;

    public YavalanchorState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public YavalanchorState(final YavalanchorState other) {
        super(other);
    }

    @Override public YavalanchorState copy() { return new YavalanchorState(this); }

}
