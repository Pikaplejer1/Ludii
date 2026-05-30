package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for SixMenSMorris. */
public class SixMenSMorrisState extends State {

    private static final long serialVersionUID = 1L;

    public SixMenSMorrisState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SixMenSMorrisState(final SixMenSMorrisState other) {
        super(other);
    }

    @Override public SixMenSMorrisState copy() { return new SixMenSMorrisState(this); }

}
