package other.state.d;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for DemalaDiviyanKeliya. */
public class DemalaDiviyanKeliyaState extends State {

    private static final long serialVersionUID = 1L;

    public DemalaDiviyanKeliyaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public DemalaDiviyanKeliyaState(final DemalaDiviyanKeliyaState other) {
        super(other);
    }

    @Override public DemalaDiviyanKeliyaState copy() { return new DemalaDiviyanKeliyaState(this); }

}
