package other.state.t;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for TwelveMenSMorris. */
public class TwelveMenSMorrisState extends State {

    private static final long serialVersionUID = 1L;

    public TwelveMenSMorrisState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public TwelveMenSMorrisState(final TwelveMenSMorrisState other) {
        super(other);
    }

    @Override public TwelveMenSMorrisState copy() { return new TwelveMenSMorrisState(this); }

}
