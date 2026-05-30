package other.state.h;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for HatDiviyanKeliya. */
public class HatDiviyanKeliyaState extends State {

    private static final long serialVersionUID = 1L;

    public HatDiviyanKeliyaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public HatDiviyanKeliyaState(final HatDiviyanKeliyaState other) {
        super(other);
    }

    @Override public HatDiviyanKeliyaState copy() { return new HatDiviyanKeliyaState(this); }

}
