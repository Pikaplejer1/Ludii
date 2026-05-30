package other.state.m;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for MangalaTurkey. */
public class MangalaTurkeyState extends State {

    private static final long serialVersionUID = 1L;

    public MangalaTurkeyState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public MangalaTurkeyState(final MangalaTurkeyState other) {
        super(other);
    }

    @Override public MangalaTurkeyState copy() { return new MangalaTurkeyState(this); }

}
