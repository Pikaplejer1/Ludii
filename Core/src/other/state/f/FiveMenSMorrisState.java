package other.state.f;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for FiveMenSMorris. */
public class FiveMenSMorrisState extends State {

    private static final long serialVersionUID = 1L;

    public FiveMenSMorrisState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public FiveMenSMorrisState(final FiveMenSMorrisState other) {
        super(other);
    }

    @Override public FiveMenSMorrisState copy() { return new FiveMenSMorrisState(this); }

}
