package other.state.p;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Plotto. */
public class PlottoState extends State {

    private static final long serialVersionUID = 1L;

    public PlottoState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public PlottoState(final PlottoState other) {
        super(other);
    }

    @Override public PlottoState copy() { return new PlottoState(this); }

}
