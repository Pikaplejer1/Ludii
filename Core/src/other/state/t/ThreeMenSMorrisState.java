package other.state.t;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for ThreeMenSMorris. */
public class ThreeMenSMorrisState extends State {

    private static final long serialVersionUID = 1L;

    public ThreeMenSMorrisState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public ThreeMenSMorrisState(final ThreeMenSMorrisState other) {
        super(other);
    }

    @Override public ThreeMenSMorrisState copy() { return new ThreeMenSMorrisState(this); }

}
