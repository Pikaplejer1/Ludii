package other.state.d;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for DiviyanKeliya. */
public class DiviyanKeliyaState extends State {

    private static final long serialVersionUID = 1L;

    public DiviyanKeliyaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public DiviyanKeliyaState(final DiviyanKeliyaState other) {
        super(other);
    }

    @Override public DiviyanKeliyaState copy() { return new DiviyanKeliyaState(this); }

}
