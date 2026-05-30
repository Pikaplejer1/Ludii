package other.state.n;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for NineMenSMorris. */
public class NineMenSMorrisState extends State {

    private static final long serialVersionUID = 1L;

    public NineMenSMorrisState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public NineMenSMorrisState(final NineMenSMorrisState other) {
        super(other);
    }

    @Override public NineMenSMorrisState copy() { return new NineMenSMorrisState(this); }

}
