package other.state.e;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for EnglishWariStLucia. */
public class EnglishWariStLuciaState extends State {

    private static final long serialVersionUID = 1L;

    public EnglishWariStLuciaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public EnglishWariStLuciaState(final EnglishWariStLuciaState other) {
        super(other);
    }

    @Override public EnglishWariStLuciaState copy() { return new EnglishWariStLuciaState(this); }

}
