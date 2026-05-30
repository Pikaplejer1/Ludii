package other.state.a;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Aqrad. */
public class AqradState extends State {

    private static final long serialVersionUID = 1L;

    public AqradState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public AqradState(final AqradState other) {
        super(other);
    }

    @Override public AqradState copy() { return new AqradState(this); }

}
