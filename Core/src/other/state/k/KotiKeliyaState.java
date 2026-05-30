package other.state.k;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for KotiKeliya. */
public class KotiKeliyaState extends State {

    private static final long serialVersionUID = 1L;

    public KotiKeliyaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public KotiKeliyaState(final KotiKeliyaState other) {
        super(other);
    }

    @Override public KotiKeliyaState copy() { return new KotiKeliyaState(this); }

}
