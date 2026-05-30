package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Sprite. */
public class SpriteState extends State {

    private static final long serialVersionUID = 1L;

    public SpriteState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SpriteState(final SpriteState other) {
        super(other);
    }

    @Override public SpriteState copy() { return new SpriteState(this); }

}
