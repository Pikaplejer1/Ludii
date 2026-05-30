package other.state.c;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Contagion. */
public class ContagionState extends State {

    private static final long serialVersionUID = 1L;

    public ContagionState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public ContagionState(final ContagionState other) {
        super(other);
    }

    @Override public ContagionState copy() { return new ContagionState(this); }

}
