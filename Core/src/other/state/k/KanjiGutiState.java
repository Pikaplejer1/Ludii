package other.state.k;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for KanjiGuti. */
public class KanjiGutiState extends State {

    private static final long serialVersionUID = 1L;

    public KanjiGutiState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public KanjiGutiState(final KanjiGutiState other) {
        super(other);
    }

    @Override public KanjiGutiState copy() { return new KanjiGutiState(this); }

}
